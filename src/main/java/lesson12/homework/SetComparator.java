package lesson12.homework;

// ДЗ проф ява:
// 1. Напишите функцию для сравнения двух сетов - boolean checkSets(Set<String> s1, Set<String> s2)
// - использовать любые операции кроме Set.equals().
// 2. * Напишите в CustomArrayDeque итератор для перебора в обратном направлении.
// 3. * Напишите в CustomArrayDeque итератор для перебора по убыванию значений элементов.
// 4. *  Напишите  функцию, которая ищет самую длинную последовательность четных чисел
// (расположенных последовательно по порядку) в передаваемом в нее List<Integer>
// и возвращает ее в виде Collection<Integer>. Пример [1,2,5,6,8,7,4] -> [6,8].

import java.util.*;

public class SetComparator {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        Set<String> s2 = new HashSet<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        long before = System.nanoTime();
        System.out.println(checkSets(s1, s2));
        long after = System.nanoTime();
        System.out.println(after - before);

        // Task Nr.4:
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 8, 10, 7, 4, 6, 8, 10));
        System.out.println(evenNumberFromList(list));


    }

    public static boolean checkSets(Set<String> s1, Set<String> s2) {
        // 1. Указывают ли ссылки s1 и s2 на один и тот же объект
        if (s1 == s2) {
            return true;
        }
        // 2. Проверяем, что оба не null
        if (s1 == null || s2 == null) {
            return false;
        }
        // 3. Сравниваем размер сетов
        if (s1.size() != s2.size()) {
            return false;
        }
//        for (String string : s1) {
//            if (!s2.contains(string)) {
//                return false;
//            }
//        }
//        return true;
        Set<String> temp = new HashSet<>(s1);
        temp.removeAll(s2);
        return temp.size() == 0;
    }

    // My
    private static boolean checkSetsMy(Set<String> s1, Set<String> s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        boolean res = false;
        if (s1.size() == s2.size()) {
            for (String s : s1) {
                if (s2.contains(s)) {
                    res = true;
                } else {
                    return false;
                }
            }
        }
        return res;
    }

    private static Collection<Integer> evenNumberFromList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0 && temp.isEmpty()) {
                temp.add(list.get(i));
                continue;
            }
            if (list.get(i) % 2 == 0 && list.get(i) == list.get(i - 1) + 2) {
                temp.add(list.get(i));
                continue;
            }
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
                temp.clear();
            }
        }
        if (temp.size() > result.size()) {
            result.clear();
            result.addAll(temp);
        }
        return result;
    }
}