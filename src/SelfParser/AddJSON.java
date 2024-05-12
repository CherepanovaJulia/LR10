package SelfParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AddJSON {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название фильма имя режиссера и год выхода:");
        String film = scanner.nextLine();
        String dir = scanner.nextLine();
        int yearOfFilm = scanner.nextInt();

// Создаем JSON объект
        JSONObject newMovie = new JSONObject();
        newMovie.put("title",film);
        newMovie.put("director", dir);
        newMovie.put("year", yearOfFilm);
//Читаем документ
        try {

            JSONParser parser = new JSONParser();
            JSONArray filmArray;

            try (FileReader fileReader = new FileReader("Movies.json")) {
                Object obj = parser.parse(fileReader);
                JSONObject jsonObject = (JSONObject) obj;
                filmArray = (JSONArray) jsonObject.get("movies");
            }

            // Добавление нового фильма
            filmArray.add(newMovie);

            // Обновление JSON объекта с новым массивом
            JSONObject updatedLibrary = new JSONObject();
            updatedLibrary.put("movies", filmArray);

            // Запись обновленного JSON в файл
            try (FileWriter file = new FileWriter("Movies.json")) {
                file.write(updatedLibrary.toJSONString());
                System.out.println("Новый фильм успешно добавлен в JSON файл.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


