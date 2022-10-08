package lesson19;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        // Stream API: Stream, primitive streams. Intermediate and Terminal operations.
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

        List<Integer> years = List.of(2000, 2022, 2021, 2027);
        //Stream<Integer> yearsStream = years.stream();  // создание потока
        years
                .stream()                      // stream creation
                .filter(y -> y % 2 == 0)       // Intermediate operation
                .filter(y -> y > 2010)         // Intermediate operation
                .forEach(System.out::println); // Terminal operation

        // создайте поток из имен Aleksander, Max, Ksenia, Maria
        // распечатайте каждое из них на экране, пропуская в поток те имена, которые содержат букву 'n'
        List<String> names = List.of("Aleksander", "Max", "Ksenia", "Maria");
        names
                .stream()
                .filter(n -> n.contains("n"))
                .forEach(System.out::println);


        // Stream Creation
        // Collection.<>stream()
        // Arrays.stream(new Integer[] {1, 2, 3})
        // Stream.of(1,2,3,4)
        // generate
        Stream<Double> randomStream =
                Stream.<Double>generate(() -> Math.random())
                        .limit(5); // сгенерировать

        randomStream.forEach(System.out::println);

        // IntStream.range(1,3) // 1 2
        // IntStream.rangeClosed(1,3) // 1 2 3

        // Intermediary functions:
        // filter() - отфильтровать элементы
        // map() - превратить элемент в какой-то другой элемент, возможно другого типа
        // limit(10) - оставить только 10 первых элементов
        // skip(5) - отбросить 5 первых элементов
        // sorted() - отсортировать элементы

        Arrays.stream(new Integer[]{1, 2, 3})
                .map(i -> i * i)
                .forEach(System.out::println);


        System.out.println("----------");
        // Напишите как преобразовать поток имен и поток длин имен
        names.stream()
                .map(String::length)
                .forEach(System.out::println);

        System.out.println("----------");
        // Взять поток имен и преобразовать его в вид "Max: 3"
        names.stream()
                .map(n -> n + ": " + n.length())
                .sorted()
                .forEach(System.out::println);

        // Как нам отправлять запросы потоку целиком?
        // 1. есть хотя бы один элемент удовлетворяющий предикату
        System.out.println(
                names.stream()
                        .anyMatch(s -> s.contains("X"))
        );

        // 2. все ли элементы удовлетворяют предикату?
        System.out.println(
                names.stream()
                        .allMatch(s -> s.contains("X"))
        );

        // 3. ни один элемент не удовлетворяет предикату.
        System.out.println(
                names.stream()
                        .noneMatch(s -> s.contains("X"))
        );

        // Reduction
        int sum = Arrays.stream(new Integer[]{1, 2, 3})
                .reduce(
                        0,
                        (prev, curr) -> prev + curr
                );
        System.out.println(sum);

        // создайте поток из 2,6,3,5
        // посчитайте произведение всех этих чисел используя reduce()
        int mul = Stream.of(2, 6, 3, 5)
                .reduce(1, (prev, curr) -> prev * curr);
        System.out.println(mul);

        // объединить все имена в одну строку
        names.stream()
                .reduce((prev, curr) -> prev + ", " + curr)
                .ifPresent(System.out::println);

        // Optional<T>
        // Решает ситуацию когда поток может не вернуть никакого значения
        // Optional либо содержит значение типа T либо признак отсутствия значения.
        // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

        Optional<Integer> firstElement =
                Arrays.stream(new Integer[]{1, 2, 3}).filter(i -> i > 200).findFirst();

//        if (firstElement.isPresent()){
//            System.out.println(firstElement.get());
//        }

        firstElement.ifPresent(System.out::println);

        Optional<String> maxString =
                names.stream().filter(s -> s.contains("W")).max(Comparator.naturalOrder());

        maxString.ifPresent(s -> System.out.println("Max string: " + s));

//        names.stream()
//                .filter(s -> s.contains("a"))
//                .max(Comparator.naturalOrder())
//                .ifPresent(s -> System.out.println("max string: " + s));


        // Collector
        // Механизм сохранения элементов потока в коллекцию
        List<String> filteredNames =
                names.stream()
                        .filter(s -> s.contains("e"))
                        .map(s -> s + ":" + s.length())
                        .collect(Collectors.toList());

        // Map<String, Integer>
        Map<String, Integer> nameToLength =
                names.stream()
                        .collect(Collectors.toMap(
                                        name -> name,
                                        name -> name.length()
                                )
                        );
        System.out.println(nameToLength);

        String namesCombined =
                names.stream()
                        .collect(
                                Collectors.joining(", ")
                        );
        System.out.println(namesCombined);

    }

    public static boolean containsString(List<String> l, String string) {
        for (String s : l)
            if (s.contains(string))
                return true;
        return false;
    }
}
