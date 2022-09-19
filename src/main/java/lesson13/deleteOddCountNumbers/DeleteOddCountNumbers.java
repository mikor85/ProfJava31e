package lesson13.deleteOddCountNumbers;

// 5. * Напишите функцию, которая принимает на вход список из целых и удаляет из него все числа,
// встречающиеся нечетное количество раз.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DeleteOddCountNumbers {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(
                Arrays.asList(1, 0, 6, 3, 4, 1, 3, 5, 0, 7, 0, 3, 0, 5, 7, 10, 7, 7, 10, 6)
        );
        System.out.println(ints);

        long before = System.currentTimeMillis();
        System.out.println(deleteOddCountNumber(ints));
        long after = System.currentTimeMillis();
        System.out.printf("Потребовалось %d мс", after - before);
        System.out.println();
    }

    private static List<Integer> deleteOddCountNumber(List<Integer> ints) {
        List<Integer> temp = new ArrayList<>();
        ints.sort(Comparator.comparing(Integer::intValue));
        for (Integer i : ints) {
            int count = findLastOccurrenceIndex(ints, i) - findFirstOccurrenceIndex(ints, i) + 1;
            if (count % 2 == 0) {
                temp.add(i);
            }
        }
        ints = temp;
        return ints;
    }

    private static int findFirstOccurrenceIndex(List<Integer> ints, int n) {
        int left = 0;
        int right = ints.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (n == ints.get(mid)) {
                result = mid;
                right = mid - 1;
            } else if (n < ints.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int findLastOccurrenceIndex(List<Integer> ints, int n) {
        int left = 0;
        int right = ints.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (n == ints.get(mid)) {
                result = mid;
                left = mid + 1;
            } else if (n < ints.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
