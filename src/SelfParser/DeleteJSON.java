package SelfParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class DeleteJSON {
    public static void main(String[] args) {
        // читаем файл
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("Movies.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("movies");

            // удаление  первого записанного фильма из файла

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject year = (JSONObject) jsonArray.get(i);
                jsonArray.remove(year);
            }
            jsonObject.put("movies", jsonArray);
            try (FileWriter file = new FileWriter("Movies.json")) {
                file.write(jsonObject.toJSONString());
                System.out.println("фильм удален из файла");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


