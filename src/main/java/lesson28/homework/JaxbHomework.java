package lesson28.homework;

// Параметризуйте через JaxB класс Emp или Car и сохраните его экземпляр в xml.

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class JaxbHomework {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);

        Car car = new Car();
        car.setMaker("audi");
        car.setModel("A6 quattro");
        car.setPrice(20_000);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(car, new File("car.xml"));
    }
}