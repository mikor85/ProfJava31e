package lesson28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericTester {
    public static void main(String[] args) {
        List list = new ArrayList();
        //list.add("hello");
        list.add(3.14159);
        //String hello = (String) list.get(0);
        //System.out.println(hello);


        List<String> names = new ArrayList<>();
        //names.add(3.14);

        logValue(3.14);
        logValue("hello");

        OrderedPair<String, String> turkey = new OrderedPair<>("Turkey", "Istanbul");
        OrderedPair<String, String> gb = new OrderedPair<>("GB", "London");
        System.out.println(equals(turkey, gb));

        System.out.println(fromArrayToList(new String[]{"Dima", "Max", "Aleksandra"}, String::length));


        Number[] numbers = new Number[]{12L, 3.14};
        Number b = 23;
        //fromArrayToList(numbers, b);  // не сработает, потому что Number не наследует Comparable
        fromArrayToList(numbers);


    } // end of main

    // T extends Number - тип T должен быть подтипом Number
    // T super Long - тип T должен быть суперклассом типа Long
    public static <T extends Number & Comparable<T>> List<T> fromArrayToList(T[] a, T bound) {
        return Arrays.stream(a)
                .filter(n -> n.compareTo(bound) > 0)
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .collect(Collectors.toList());
    }

    public static <T extends Number> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a)
                // side-effect - пропускает элемент без изменения и только что-нибудь с ним делает
                // метод doubleValue() определён в Number и поэтому без ограничения exstends Number
                // код не скомпилируется
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .collect(Collectors.toList());
    }

    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    // то же самое, но нужно преобразовывать тип
    public static <T, R> List<R> fromArrayToList(T[] a, Function<T, R> mapper) {
        return Arrays.stream(a)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <K, V> boolean equals(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static <T> void logValue(T t) {
        System.out.println("This is a " + t.getClass().getSimpleName() + " " + t);
    }

    public static void logStringValue(String s) {
        System.out.println("This is a String " + s);
    }

    public static void logDoubleValue(String d) {
        System.out.println("This is a Double " + d);
    }
}
