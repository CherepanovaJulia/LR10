package SelfParser;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class CreateXML {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //создание корневого элемента

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Mediateka");
            doc.appendChild(rootElement);

            // добавление первого фильма
            Element movie1 = doc.createElement("movie");
            rootElement.appendChild(movie1);
            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Мстители"));
            movie1.appendChild(title1);

            Element director1 = doc.createElement("director");
            director1.appendChild(doc.createTextNode("Джосс Уидон"));
            movie1.appendChild(director1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("2012"));
            movie1.appendChild(year1);

            // добавление второго фильма
            Element movie2 = doc.createElement("movie");
            rootElement.appendChild(movie2);
            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Стражи галактики"));
            movie2.appendChild(title2);

            Element director2 = doc.createElement("director");
            director2.appendChild(doc.createTextNode("Джеймс Ганн"));
            movie2.appendChild(director2);

            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("2014"));
            movie2.appendChild(year2);

            //запись XML- файла
            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);

            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new File("movie.xml"));

            transformer.transform(source,result);

            System.out.println("XML с фильмами  создан");
        }
        catch (Exception pce){
            pce.printStackTrace();
        }
    }
}

