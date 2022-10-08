package lesson18;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lesson18 {

    // Existing Functional Interfaces in Java 8. Functions and Predicates.

    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    // https://cloud.mail.ru/public/jERz/aq5Q9bU6A

    public static void main(String[] args) {
        // Function

        Function<String, Integer> stringToLength = String::length;
        Function<Double, String> doubleString = d -> "double: " + d;

        System.out.println(doubleString.apply(334.2));

        Map<String, Integer> nameMap = new HashMap<>();
        Integer v = nameMap.computeIfAbsent("John", String::length);

        List<Integer> res =
                Stream.of("John", "Max", "Alexander", "Vasilisa")
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(res);

        System.out.println("########");
        // compose
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Double, String> doubleQuote = quote.compose(doubleString);
        System.out.println(doubleQuote.apply(33.4));
        System.out.println("########");

        // BiFunction
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 15_000);
        salaries.put("Masha", 25_000);
        salaries.put("Alex", 17_000);
        salaries.put("Samuel", 33_000);

//        salaries.replaceAll(new BiFunction<String, Integer, Integer>() {
//            @Override
//            public Integer apply(String name, Integer salary) {
//                return name.equals("Samuel") ? salary : salary + 2_000;
//            }
//        });

        salaries.replaceAll(
                (name, salary) -> name.equals("Samuel") ? salary : salary + 2_000
        );
        System.out.println(salaries); // andThen


        // Supplier
        // функция, которая не принимает параметров, но что-то возвращает
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier<Double> lazyValue = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Math.random() * 100;
        };

        double result = lazyValue.get();
        System.out.println(result);


        // Consumer
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html
        // получает аргумент какого-типа и ничего не возвращает
        // используется для сайд-эффектов
        // andThen
        List<String> names = Arrays.asList("John", "Max", "Alexander", "Vasilisa");
        names.forEach(System.out::println);

        // BiConsumer

//        salaries.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String name, Integer salary) {
//                System.out.println("name: " + name+ ", salary: " + salary);
//            }
//        });

        salaries.forEach(
                (name, salary) -> System.out.println("name: " + name + ", salary: " + salary)
        );

        // Predicate
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        // тест на соответствие элемента какому-нибудь условию
        // возвращает boolean
        // and() or() negate()
        // Predicate.not(...)
        // BiPredicate
        List<String> namesLongerThen5 =
                names
                        .stream()
                        .filter(s -> s.length() >= 5)
                        .collect(Collectors.toList());
        System.out.println(namesLongerThen5);


        // Operator

        // специализация Function с одинаковым типом входного и выходного
        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        int sum = values.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}