package lesson28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Double> doubleList = List.of(1.0, 2.3, 3.1, 4.7, 5.9);

        printListOfNumber(integerList);
        printListOfNumber(doubleList);

        List<Number> numberList = new ArrayList<>(List.of(1, 2.3));

        addNumber(numberList);
    }

    // Producer function
    // только добавляет элементы в список
    // public static void addNumber(List<Integer> integerList) {
    public static void addNumber(List<? super Integer> integerList) {
        integerList.add(new Random().nextInt());
    }

    // Consumer function
    // контракт - numberList в функции не меняется
    // public static void printListOfNumber(List<Number> numberList) {
    public static void printListOfNumber(List<? extends Number> numberList) {
        numberList.forEach(n -> System.out.println("number: " + n));
    }
}