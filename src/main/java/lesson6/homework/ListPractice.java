package lesson6.homework;

import java.util.Arrays;
import java.util.List;

public class ListPractice {
// ДЗ проф ява:
//  1. Напишите функцию, которая последовательно сравнивает между собой элементы
//  из двух передаваемых в нее списков одинаковой длины.
//  Если все элементы в списках попарно одинаковы, возвращает true.
//  Пример: {1,2,3}, {4,5,6} -> false; {1,2}, {1,2} -> true; {1,2}, {2,1} -> false.

//  2. Напишите функцию, которая последовательно сравнивает элементы двух передаваемых
//  в нее списков одинаковой длины, и возвращает список строк.
//  Пример: {1,2,3}, {1,4,3}->{"Yes", "No", "Yes"}.

//  3. * Напишите функцию, которая получает на вход список строк и
//  возвращает либо самую короткую, либо саму длинную, в зависимости от того, какая встретилась раньше.

//  4. * Напишите функцию, которая удаляет дубликаты из передаваемого в нее массива строк.

    public static void main(String[] args) {
        System.out.println("Task 1:");
        List<Integer> s1 = Arrays.asList(1, 2, 3);
        List<Integer> s2 = Arrays.asList(1, 2, 3);
        System.out.println(checkRelevantElements(s1, s2));
        System.out.println("----------");


    }

    // Task 1
    public static boolean checkRelevantElements(List<Integer> s1, List<Integer> s2) {
        int count = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i).equals(s2.get(i))) {
                count++;
            }
        }
        return count == s1.size();
    }

    // Task 2
}
