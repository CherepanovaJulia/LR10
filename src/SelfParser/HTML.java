package SelfParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class HTML {
    public static void main(String[] args) {
        try {
            // Подключаемся к сайту
            Document doc = connectWithRetry("https://eyeclinic.ru/");
            // Находим все элементы с классом "mobile_menu-item"
            Elements menuBlocks = doc.getElementsByClass("mobile_menu-item");

            // Записываем полученные данные в файл
            writeToFile(menuBlocks, "menu.txt");

            // Проходим по всем найденным элементам
            for (Element menuBlock : menuBlocks) {
                // Извлекаем текст заголовка новости
                String title = menuBlock.text();

                // Выводим заголовок новости
                System.out.println("Раздел сайта: " + title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Функция для подключения к сайту с возможностью переподключения в случае ошибки
    private static Document connectWithRetry(String url) throws IOException {
        int maxRetries = 3;
        int retries = 0;
        while (true) {
            try {
                return Jsoup.connect(url).get();
            } catch (IOException e) {
                retries++;
                if (retries == maxRetries) {
                    throw e;
                }
                System.out.println("Ошибка при подключении к сайту. Попытка переподключения...");
            }
        }
    }

    // Функция для записи данных в файл
    private static void writeToFile(Elements data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (Element element : data) {
                fileWriter.write("Раздел сайта: " + element.text() + "\n");
            }
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}

