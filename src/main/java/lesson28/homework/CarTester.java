package lesson28.homework;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class CarTester {
    public static void main(String[] args) throws JAXBException {
        Park park = new Park();

        park.setAddress("Main street, 54");

        park.setCars(
                new ArrayList<>(
                        Arrays.asList(
                                new Car("Peugeot", "407", 21_000),
                                new Car("Nissan", "Patrol", 16_500)
                        )
                )
        );

        JAXBContext context = JAXBContext.newInstance(Park.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(park, new File("CarPark.xml"));

    }
}
