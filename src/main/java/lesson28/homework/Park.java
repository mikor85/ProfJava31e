package lesson28.homework;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "PARK")
public class Park {
    private String address;
    private List<Car> cars = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    @XmlAttribute(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "CAR")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}