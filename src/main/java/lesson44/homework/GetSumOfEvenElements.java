package lesson44.homework;

import java.util.stream.IntStream;

public class GetSumOfEvenElements {

    public static void main(String[] args) {
        //                0   1   2  3  4   5
        int[] numbers = {2, 14, 22, 1, 17, 8};
        System.out.println(getSum(numbers));
        // С помощью Stream-ов посчитайте сумму нечетных элементов
        // массива целых - воспользуйтесь IntStream.range(0, ...)
        // для генерации последовательности номеров элементов -
        // подумайте, как превратить их в нечетные числа?
    }

    public static int getSum(int[] arr) {
        return IntStream.range(0, arr.length / 2)
                // 2*N + 1
                .map(i -> 2 * i + 1)
                .map(i -> arr[i])
                .sum();
    }
}