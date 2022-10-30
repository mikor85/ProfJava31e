package lesson24.homework;

class Car {
    public String maker;
    public String model;
    public double price;

    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
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