package SelfParser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    public static void main(String[] args) {
        try {
            // Создаем новую книгу Excel
            Workbook workbook = new XSSFWorkbook();
            // Создаем новый лист в книге
            Sheet sheet = workbook.createSheet("Товары");

            // Создаем заголовок таблицы
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Название товара", "Характеристики", "Стоимость"};

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Добавляем данные
            String[][] data = {
                    {"Книга", "Автор: Иванов, Год: 2023", "1000"},
                    {"Компьютер", "Процессор: Intel Core i7, RAM: 16GB", "50000"}
            };

            int rowNum = 1;
            for (String[] rowData : data) {
                Row row = sheet.createRow(rowNum++);

                int colNum = 0;
                for (String value : rowData) {
                    Cell cell = row.createCell(colNum++);
                    cell.setCellValue(value);
                }
            }

            // Записываем данные в файл
            try (FileOutputStream outputStream = new FileOutputStream("output.xlsx")) {
                workbook.write(outputStream);
            }

            // Закрываем книгу Excel
            workbook.close();

            System.out.println("Данные успешно записаны в файл output.xlsx");

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
