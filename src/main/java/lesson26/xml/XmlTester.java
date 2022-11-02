package lesson26.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // parse - попытаться извлечь полезную информацию
        // SAX - потоковая библиотека, которая не строит дерево
        // есть колбэки, которые выполняются при нахождении элемента, атрибута и т.п.
        // требуется меньше памяти и это быстрее

        // DOM - Document Object Model - строит полное дерево документа в памяти
        // упрощает навигацию по документу и поиск в нем полезной информации
        // требуется память на хранение и построение дерева

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        // doc - DOM дерево построено в памяти
        Element root = doc.getDocumentElement();  // CATALOG
        NodeList priceNodeList = root.getElementsByTagName("PRICE"); // список элементов с именем PRICE
        for (int i = 0; i < priceNodeList.getLength(); i++) {
            Node priceNode = priceNodeList.item(i);  // конкретный элемент с именем PRICE
            System.out.println(
                    priceNode.getFirstChild()
                            .getTextContent()
            );
        }

        printNode("", root);

        System.out.println("----------");

        printAttributes("", root);

    }  // end of main

    private static void printNode(String prefix, Element element) {
        System.out.println(
                prefix +
                        " element name " + element.getNodeName() +
                        " type " + element.getNodeType() +
                        printTextValue(element)

        );
        printAttributes(prefix + "\t", element);
        NodeList children = element.getChildNodes();  // все дочерние элементы текущего
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);  // Node - может быть элемент, атрибут и текстовое значение
            if (node instanceof Element) {
                printNode(prefix + "\t", (Element) node);
            }
        }
    }

    public static String printTextValue(Element element) {
        //                      текстовой элемент     значение
        return " value " + element.getFirstChild().getTextContent();
    }

    // распечатывает атрибуты элементов
    public static void printAttributes(String prefix, Element element) {
        NamedNodeMap namedNodeMap = element.getAttributes();  // все атрибуты элемента
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node attributeNode = namedNodeMap.item(i);
            System.out.println(
                    prefix +
                            " attr name " + attributeNode.getNodeName() +
                            " value " + attributeNode.getNodeValue()
            );
        }
    }
}
