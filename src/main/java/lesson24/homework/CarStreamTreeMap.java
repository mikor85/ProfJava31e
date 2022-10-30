package lesson24.homework;

// 2. *** Переделать четвертое задание (с машинами) на stream.

import java.util.List;
import java.util.TreeMap;

public class CarStreamTreeMap {
    public static void main(String[] args) {
        System.out.println("----------");
        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1, c2, c3, c4, c5, c6);
        System.out.println(sortCarsStream(cars));
    }

    public static TreeMap<String, List<Car>> sortCarsStream(List<Car> cars) {

        return null;
    }
}