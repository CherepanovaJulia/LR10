package Sample;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSON {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Война и мир");
        book1.put("author", "Лев Толстой");
        book1.put("year", "1869");

        JSONObject book2 = new JSONObject();
        book2.put("title", "Мастер и Маргарита");
        book2.put("author", "Михаил Булгаков");
        book2.put("year", "1967");

        books.add(book1);
        books.add(book2);

        library.put("books", books);

        try (FileWriter file = new FileWriter("JSONfile.json")) {
            file.write(library.toJSONString());
            System.out.println("Json-файл создан");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
