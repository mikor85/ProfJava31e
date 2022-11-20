package lesson44.homework;

import java.util.Arrays;

public class GetSumOfOddElements {

    public static int getSum(int[] arr) {
        return Arrays.stream(arr)
                .filter(i -> i % 2 == 0)
                .sum();
    }
}