package lesson28.homework;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CAR")
public class Car {
    private String maker;
    private String model;
    private double price;

    public Car() {
    }

    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    @XmlElement(name = "MAKER")
    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    @XmlElement(name = "MODEL")
    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    @XmlElement(name = "PRICE")
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "ma='" + maker + '\'' +
                ", mo='" + model + '\'' +
                ", p=" + price +
                '}';
    }
}