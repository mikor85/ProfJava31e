package lesson26.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbTester {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(new File("test.xml"));
//        System.out.println(catalog);

        Plant plant = new Plant();
        plant.setAvailability("a");
        plant.setBotanical("b");
        plant.setCommon("c");
        plant.setLight("l");
        plant.setPrice("p");
        plant.setZone("");
        plant.setPlantid("id");


        Catalog catalog = new Catalog();
        catalog.setName("name");
        catalog.setSize("size");
        catalog.setPlants(new ArrayList<>(List.of(plant)));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(catalog, new File("newcatalog.xml"));
    }
}