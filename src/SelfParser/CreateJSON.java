package SelfParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;

public class CreateJSON {
    public static void main (String[]args){
        JSONObject mediateka = new JSONObject();
        JSONArray mov = new JSONArray();

        JSONObject movie1 = new JSONObject();
        movie1.put("title", "Мстители");
        movie1.put("director", "Джосс Уидон");
        movie1.put("year", "2012");

        JSONObject movie2 = new JSONObject();
        movie2.put("title", "Стражи Галактики");
        movie2.put("director", "Джеймс Ганн");
        movie2.put("year", "2014");

        mov.add(movie1);
        mov.add(movie2);

        mediateka.put("movies", mov);

        try (FileWriter file = new FileWriter("Movies.json")) {
            file.write(mediateka.toJSONString());
            System.out.println("Json-файл создан");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


