package lesson8;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        int[] l = {1, 2, 3};

        // итератор - это интерфейс,
        // итератор позволяет обойти все элементы любого класса, который имплементит Iterable<T>.

        List<String> names = new ArrayList<>();
        names.add("Max");
        names.add("Oksana");

        Iterator<String> iterator = names.iterator();  // метод из Iterable<T>
        while (iterator.hasNext()) {                    // метод из Iterator<T>
            System.out.println(iterator.next());       // метод из Iterator<T>
        }

        System.out.println("----------");

        Set<String> countries = new HashSet<>();
        Set<String> capitals = new TreeSet<>();
        countries.add("Canada");
        countries.add("France");
        countries.add("Spain");

        Iterator<String> setIterator = countries.iterator();
        while (setIterator.hasNext()) {
            System.out.println(setIterator.next());
        }

    }  // end of main


}
