package SelfParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Scanner;

public class SearchJSON {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите название фильма: ");
        String search = in.nextLine();

// Читаем JSON документ
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("Movies.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("movies");

            boolean searchMovie = false;

            for (Object o : jsonArray) {
                JSONObject movie = (JSONObject) o;
                String film = (String) movie.get("title");
                if (film.equalsIgnoreCase(search)) {
                    System.out.println("Файл содержит фильм");
                    System.out.println(movie.get("title"));
                    System.out.println(movie.get("director"));
                    System.out.println(movie.get("year"));
                    searchMovie = true;
                }
            }
            if (!searchMovie){
                System.out.println("Фильм не найден");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

