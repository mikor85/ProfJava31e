package lesson15.hashMap;

import java.util.Objects;

public class Car {
    private String vendor; // Audi, Fiat etc
    private String model;
    private double price;

    public Car(String vendor, String model, double price) {
        this.vendor = vendor;
        this.model = model;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.price, price) != 0) return false;
        if (!Objects.equals(vendor, car.vendor)) return false;
        return Objects.equals(model, car.model);
    }

    // Условия эффективного использования наших классов в хэш контейнере
    // 1. Если два объекта эквивалентны, то их хэш-коды должны быть одинаковые.
    // 2. Хэш-код должен меняться в процессе жизни объекта.

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = vendor != null ? vendor.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
