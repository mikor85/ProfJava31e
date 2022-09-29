package lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
        // Lambdas, Functional Interface, Method references

        // лямбда выражение - это ссылка на анонимный метод,
        // является реализацией SAM интерфейса - Single Abstract Method.
        // Основа лямбды выражения - интерфейс с единственным абстрактным методом.

        /*
        NoArgsReturnsDouble noNoArgsReturnDouble = new NoArgsReturnsDouble() {
            @Override
            public double function() {
                return Math.random() * 256;
            }
        };

         */

        // лямбда выражение
        NoArgsReturnsDouble noNoArgsReturnDouble = () -> Math.random() * 256;
        System.out.println("NoArgsReturnsDouble " + noNoArgsReturnDouble.function());

        /*
        NoArgsReturnsDouble returns10 = new NoArgsReturnsDouble() {
            @Override
            public double function() {
                return 10;
            }
        };
         */

        // лямбда выражение
        NoArgsReturnsDouble returns10 = () -> 10;
        System.out.println(returns10.function());

        // напишите лямбду, которая сравнит два аргумента на равенство
        // если равны вернуть true если не равны false
        TwoIntArgsReturnsBoolean l1 = (i, j) -> i == j;
        System.out.println("равенство 10, 12 ? - " + l1.function(10, 12));
        System.out.println("равенство 50, 50 ? - " + l1.function(50, 50));
        System.out.println("равенство 3, 3 ? - " + process(l1, 3, 3));

        // напишите лямбду, которая вернёт true если первый аргумент делится на второй без остатка
        TwoIntArgsReturnsBoolean l2 = (i, j) -> i % j == 0;
        System.out.println("делимость 50 на 10 - " + process(l2, 50, 10));

        PredicateInt p1 = (i) -> i % 2 == 0; // только четные элементы
        Collection<Integer> input = List.of(1, 3, 5, 8, 2, 17);
        Collection<Integer> result = filterMy(p1, input);
        System.out.println(result);

        // То же самое без цикла for
        input.stream().filter((i) -> i % 2 == 0).forEach(System.out::println);

        // Применения StringProcessor
        //StringProcessor pp1 = (s) -> s.substring(0, 1);
        // многострочное лямбда выражение
        StringProcessor pp1 = (s) -> {
            return s.substring(0, 1);
        };
        //StringProcessor pp2 = (s) -> s.toUpperCase();

        // lambda method reference
        StringProcessor pp2 = String::toUpperCase;
        System.out.println(
                process(pp1, List.of("Max", "Dina", "Alex"))
        );
        System.out.println(
                process(pp2, List.of("Max", "Dina", "Alex"))
        );

        process(
                (s) -> s.toLowerCase(),
                List.of("Max", "Dina", "Alex")
        );


        DoubleValue d = new DoubleValue(12.0);
        // DoubleProcessor dp = (w) -> d.multiply(w);
        // lambda instance method reference
        DoubleProcessor dp = d::multiply;

//        DoubleValueCreator creator = (dbl) -> {
//            System.out.println("Hello");
//            return new DoubleValue(dbl);  // в многострочном лямбда выражении обязательно писать return
//        };

        // lambda constructor reference
        DoubleValueCreator creator = DoubleValue::new;

        GenericProcessor<String> sp1 = (s) -> s.toLowerCase();
        GenericProcessor<Double> dp1 = (dd) -> Math.pow(dd, 3);

        List<String> names = List.of("Galina", "Olga", "Gerasim");
        System.out.println(
                processGeneric(sp1, names)
        );

        System.out.println(
                processGeneric(dp1, List.of(1.0, 2.0, 3.9))
        );

    }

    public static <K> List<K> processGeneric(GenericProcessor<K> p, List<K> input) {
        List<K> result = new ArrayList<>();
        for (K t : input) {
            result.add(p.apply(t));
        }
        return result;
    }

    // напишите функцию, которая принимает на вход List<String> и возвращает
    // List<String> после применения StringProcessor
    public static List<String> process(StringProcessor p, List<String> input) {
        List<String> result = new ArrayList<>();
        for (String s : input) {
            result.add(p.apply(s));
        }
        return result;
    }


    public static boolean process(TwoIntArgsReturnsBoolean c, int k, int m) {
        return c.function(k, m);
    }

    // напишите функция, которая принимает на вход Collection<Integer>, PredicateInt
    // и возвратит Collection<Integer> только для тех элементов коллекции, которые
    // удовлетворяют предикату

    public static Collection<Integer> filterMy(PredicateInt p, Collection<Integer> input) {
        Collection<Integer> result = new ArrayList<>();
        for (Integer i : input) {
            if (p.function(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
