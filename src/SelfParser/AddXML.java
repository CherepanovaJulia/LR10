package SelfParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AddXML {
    public static void main(String[] args) {
        System.out.println("введите название фильма, имя режиссера и год выпуска: ");
        Scanner in = new Scanner(System.in);
        String movieTitle = in.nextLine();
        String movieDirector = in.nextLine();
        String movieYear = in.nextLine();

        try {

            File newMovie = new File("movie.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            Document doc = dbf.newDocumentBuilder().parse(newMovie);
            doc.getDocumentElement().normalize();
            Element movie3 = doc.createElement("movie");

            doc.getDocumentElement().getNodeName();
            System.out.println("Корневой элемент" + " " + doc.getDocumentElement().getNodeName());
            // NodeList nodeList =
            doc.getElementsByTagName("movie");
            Node node = doc.getLastChild();

            //запись третьего фильма в файл

            Element title3 = doc.createElement("title");
            node.appendChild(movie3);
            title3.appendChild(doc.createTextNode( movieTitle));
            movie3.appendChild(title3);

            Element director3 = doc.createElement("director");
            director3.appendChild(doc.createTextNode(movieDirector));
            movie3.appendChild(director3);

            Element year3 = doc.createElement("year");
            year3.appendChild(doc.createTextNode( movieYear));
            movie3.appendChild(year3);

            // запись нового элемента в xml
            javax.xml.transform.Transformer transformer =
                    javax.xml.transform.TransformerFactory.newInstance().newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("movie.xml"));
            transformer.transform(source, result);
            System.out.println("Новый фильм добавлен в xml файл");


        } catch(Exception pce){
            pce.printStackTrace();

        }
    }
}


