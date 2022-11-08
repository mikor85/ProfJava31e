package lesson29;

import lesson28.homework.Car;

import java.util.Random;

public class Probe {

    public static Object getCar(){
        return new Car("Peugeot", "407", 20_000);
    }

    public static String getMessage(int i) {
        return i > 5 ? "Hello" : "World";
    }

    public static String getMessage() {
        int i = new Random(10).nextInt();
        return i > 5 ? "Hello" : "World";
    }
}
