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

        // Task Nr.2:
        System.out.println("----------");
        System.out.println(getElementValue(root));


    }

    // Task Nr.1:
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

    public static String getElementValue(Element element) {
        StringBuilder b = new StringBuilder();
        NodeList nodeList = element.getElementsByTagName("BOTANICAL");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (i < nodeList.getLength() - 1){
                b.append(node.getTextContent()).append(";");
            } else {
                b.append(node.getTextContent());
            }
        }
        return b.toString();
    }
}