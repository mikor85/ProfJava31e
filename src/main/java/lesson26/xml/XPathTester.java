package lesson26.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        // https://www.w3schools.com/xml/xpath_intro.asp

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        // doc - DOM дерево построено в памяти
        Element root = doc.getDocumentElement(); // CATALOG

        // XPath - механизм отправки запросов к xml-документу
        XPath xPath = XPathFactory.newInstance().newXPath();
        /*
            /CATALOG - корневой элемент с названием CATALOG
            //LIGHT - все элементы с названием LIGHT в любом месте документа
            /CATALOG/PLANT - все элементы PLANT являющиеся дочерними элементами корневого элемента CATALOG
            //MOVIE/ACTOR - все элементы ACTOR являющиеся дочерними для элемента MOVIE из любого места документа
            //PLANT[@plantid='456']/PRICE - элемент PRICE, у которого родительский элемент PLANT с атрибутом ...
         */


        XPathExpression xPathExpression = xPath.compile("//PLANT[@plantid='456']/PRICE");
        Node price = (Element) xPathExpression.evaluate(doc, XPathConstants.NODE);

        System.out.println(price.getFirstChild().getTextContent());
        //System.out.println(price.getTextContent());

        XPathExpression xPathExpression1 = xPath.compile("//PLANT[@plantid='456']/PRICE | //AVAILABILITY");
        NodeList nodes = (NodeList) xPathExpression1.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(
                    "price or availability: " + ((Element) nodes.item(i)).getFirstChild().getTextContent()
            );
        }


    }
}