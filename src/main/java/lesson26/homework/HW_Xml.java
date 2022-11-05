package lesson26.homework;

// ДЗ проф ява
// 1. Напишите функцию, которая принимает на вход Element и
// складывает значения атрибутов plantid из его дочерних элементов PLANT (579)

// 2. Найдите себе любой xml документ и поэкспериментируйте с ним из явы - например,
// соберите текстовые значения всех его определенных элементов в строку через StringBuilder.
// Например, собрать через ";" значения всех элементов BOTANICAL - "Sanguinaria canadensis;Aquilegia canadensis".

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class HW_Xml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        Element root = doc.getDocumentElement();

        // Task Nr.1:
        System.out.println(getPlantIdAttributesSum(root));
        System.out.println("----------");
        System.out.println(sumPlantId(root));

        // Task Nr.2:
        System.out.println("----------");
        System.out.println(getElementValue(root));
        System.out.println("----------");
        System.out.println(
                joinElementTextContent(
                        root.getElementsByTagName("BOTANICAL")
                )
        );
    }  // end of main

    // Task Nr.1:
    public static int sumPlantId(Element element) {
        int plantIdSum = 0;
        // найдем дочерние элементы PLANT
        NodeList plantNodeList = element.getElementsByTagName("PLANT");
        for (int i = 0; i < plantNodeList.getLength(); i++) {
            Element plant = (Element) plantNodeList.item(i);
            plantIdSum += Integer.parseInt(plant.getAttribute("plantid"));
        }
        // у элементов найдем атрибут plandid
        // сложим значения plantid
        // вернем
        return plantIdSum;
    }

    // My
    public static int getPlantIdAttributesSum(Element element) {
        int sum = 0;
        NodeList plantNodeList = element.getElementsByTagName("PLANT");
        for (int i = 0; i < plantNodeList.getLength(); i++) {
            Node plantNode = plantNodeList.item(i);
            if (plantNode.hasAttributes()) {
                NamedNodeMap namedNodeMap = plantNode.getAttributes();
                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    Node attrNode = namedNodeMap.item(j);
                    sum += Integer.parseInt(attrNode.getNodeValue());
                }
            }
        }
        return sum;
    }

    // Task Nr.2:
    public static String joinElementTextContent(NodeList nodeList) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            // Node - Element, Attribute, NameSpace, Comment, TextNode, Processing Instruction
            if (i != 0)
                builder.append("; ");
            builder.append(element.getFirstChild().getTextContent());
        }
        return builder.toString();
    }

    // My
    public static String getElementValue(Element element) {
        StringBuilder b = new StringBuilder();
        NodeList nodeList = element.getElementsByTagName("BOTANICAL");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (i < nodeList.getLength() - 1) {
                b.append(node.getTextContent()).append("; ");
            } else {
                b.append(node.getTextContent());
            }
        }
        return b.toString();
    }
}