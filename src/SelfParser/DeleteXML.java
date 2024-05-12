package SelfParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DeleteXML {
    public static void main(String[] args) {
        try {
            File inputFile = new File("movie.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент " + doc.getDocumentElement().getNodeName());
            NodeList yearList = doc.getElementsByTagName("year");

            for (int i = 0; i < yearList.getLength(); i++) {
                Element yearElement = (Element) yearList.item(i);

                    Node parentNode = yearElement.getParentNode();
                    parentNode.removeChild(yearElement);
                System.out.println("Элемент year удален");

                // перезаписываем файл
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("movie.xml");
                transformer.transform(source, result);
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

