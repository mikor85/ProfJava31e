package lesson23.homework;

// ДЗ проф ява:
// 1. * Напишите коллектор который из потока целых вычисляет Double среднее значение.

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AverageFromIntCollector {
    public static void main(String[] args) {
        List<Integer> intList1 = List.of(0, 1, 2, 3, 4, 5, 6);
        System.out.println("average value of list1 = " + getIntsAverageStream(intList1));
        List<Integer> intList2 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("average value of list2 = " + getIntsAverageStream(intList2));
        System.out.println("average value of list1 = " + getIntsAverageCollector(intList1));
    }

    public static double getIntsAverageCollector(List<Integer> integerList) {
        return integerList.stream()
                .collect(new Collector<Integer, List<Integer>, Double>() {
                    @Override
                    public Supplier<List<Integer>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<Integer>, Integer> accumulator() {
                        return List::add;
                    }

                    @Override
                    public BinaryOperator<List<Integer>> combiner() {
                        return (ints1, ints2) -> {
                            ints1.addAll(ints2);
                            return ints1;
                        };
                    }

                    @Override
                    public Function<List<Integer>, Double> finisher() {
                        return integers -> {
                            OptionalDouble res =
                                    integers.stream().mapToDouble(i -> i).average();
                            return res.isPresent() ? res.getAsDouble() : null;
                        };
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED);
                    }
                });
    }

    public static double getIntsAverageStream(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(i -> i)
                .average().orElse(0);
    }
}