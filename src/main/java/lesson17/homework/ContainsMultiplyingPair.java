package lesson17.homework;

// 3. * Напишите метод, который вернет true если в массиве присутствуют два числа,
// произведение которых даст нужное число. Пример [5, 7, 12, 2] , 10 -> true:
// => public static boolean test(int [] a, int b)

import java.util.ArrayList;
import java.util.List;

public class ContainsMultiplyingPair {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 12, 2};
        int multiplyNumber = 10;
        System.out.println(containsMultiplyingPair(array, multiplyNumber));
    }

    private static boolean containsMultiplyingPair(int[] array, int multiplyNumber) {
        // List<Integer> arrList = Arrays.asList(array);

        List<Integer> arrList = new ArrayList<>();
        for (Integer i : array) {
            arrList.add(i);
        }
        if (arrList.size() < 2) {
            return false;
        }
        List<Integer> temp = new ArrayList<>(arrList);
        for (int i = 0; i < arrList.size(); i++) {
            if (multiplyNumber == 0 && arrList.contains(0)) {
                return true;
            }
            if (multiplyNumber != 0 && arrList.get(i) == 0) {
                continue;
            }
            if (multiplyNumber % arrList.get(i) != 0) {
                continue;
            }
            int numberTwo = multiplyNumber / arrList.get(i);
            temp.remove(i);
            if (temp.contains(numberTwo)) {
                return true;
            }
            temp.addAll(arrList);
        }
        return false;
    }
}