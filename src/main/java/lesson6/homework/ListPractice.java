package lesson6.homework;

import java.util.ArrayList;
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
//  возвращает либо самую короткую, либо самую длинную, в зависимости от того, какая встретилась раньше.

//  4. * Напишите функцию, которая удаляет дубликаты из передаваемого в нее массива строк.

    public static void main(String[] args) {
        System.out.println("Task 1:");
        List<Integer> s11 = Arrays.asList(1, 2, 3);
        List<Integer> s12 = Arrays.asList(1, 2, 3);
        System.out.println(checkRelevantElements(s11, s12));
        System.out.println("----------");
        System.out.println(checkRelevantElementsVer2(s11, s12));
        System.out.println("----------");

        System.out.println("Task 2:");
        List<Integer> s21 = Arrays.asList(1, 2, 3, 4);
        List<Integer> s22 = Arrays.asList(1, 1, 3, 5);
        System.out.println(isEqualElements(s21, s22));
        System.out.println("----------");

        System.out.println("Task 3:");
        List<String> s31 = Arrays.asList("Dog", "Penguin", "Horse", "Elephant");
        List<String> s32 = Arrays.asList("Elephant", "Dog", "Penguin", "Horse");
        System.out.println(firstMetShortestOrLongestString(s31));
        System.out.println(firstMetShortestOrLongestString(s32));
        System.out.println("----------");

        System.out.println("Task 4:");
        List<String> s4 = Arrays.asList("Car", "Truck", "Bicycle", "Car", "Buggy", "Train", "Truck", "Plane", "Rocket", "Plane");
        System.out.println(optimizedList(s4));
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

    public static boolean checkRelevantElementsVer2(List<Integer> s1, List<Integer> s2) {
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i).equals(s2.get(i))) {
                continue;
            } else return false;
        }
        return true;
    }

    // Task 2
    public static List<String> isEqualElements(List<Integer> s1, List<Integer> s2) {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i).equals(s2.get(i))) {
                s.add(i, "Yes");
            } else s.add(i, "No");
        }
        return s;
    }

    // Task 3
    public static String firstMetShortestOrLongestString(List<String> s) {
        StringBuilder stringRes = new StringBuilder("");
        int minL = s.get(0).length();
        int minLIndex = 0;
        int maxL = s.get(0).length();
        int maxLIndex = 0;
        for (int i = 1; i < s.size(); i++) {
            if (s.get(i).length() < minL) {
                minL = s.get(i).length();
                minLIndex = i;
            }
            if (s.get(i).length() > maxL) {
                maxL = s.get(i).length();
                maxLIndex = i;
            }
        }
        if (minLIndex < maxLIndex) {
            stringRes.append(s.get(minLIndex));
        } else stringRes.append(s.get(maxLIndex));
        return stringRes.toString();
    }

    // Task 4
    public static List<String> optimizedList(List<String> s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.size() - 1; i++) {
            for (int j = i + 1; j < s.size() - 1; j++) {
                if (s.get(i).equals(s.get(j))) {
                    s.set(j, "0");
                }
            }
        }
        for (String value : s) {
            if (!value.equals("0")) {
                res.add(value);
            }
        }
        return res;
    }
}
