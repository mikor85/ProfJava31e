package lesson23.homework;

// ДЗ проф ява:
// 1. * Напишите коллектор который из потока целых вычисляет Double среднее значение.

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AverageFromIntCollector {
    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 2, 3, 4, 5, 6};
        List<Integer> integerList = List.of(0, 1, 2, 3, 4, 5, 6);
        System.out.println("average value of list1 = " + getIntsAverageStream(integerList));
        List<Integer> integerList2 = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("average value of list2 = " + getIntsAverageStream(integerList2));
        List<Integer> resultList = List.of(0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("average value of resultList = " + getIntsAverageStream(resultList));

        double average1 = getIntsAverageStream(integerList);
        double average2 = getIntsAverageStream(integerList2);
        System.out.println((average1 + average2) / 2);

    }

    public static double getIntsAverageCollector(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(i -> i)
                .collect(new Supplier<Double>() {
                             @Override
                             public Double get() {
                               return null;
                             }
                         },
                        new ObjIntConsumer<Double>() {
                            @Override
                            public void accept(Double res, int value) {

                            }
                        },
                        new BiConsumer<Double, Double>() {
                            @Override
                            public void accept(Double d1, Double d2) {

                            }
                        });
    }

    public static double getIntsAverageStream(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(i -> i)
                .average().orElse(0);
    }
}
