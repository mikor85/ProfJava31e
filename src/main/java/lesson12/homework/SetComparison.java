package lesson12.homework;

// ДЗ проф ява:
// 1. Напишите функцию для сравнения двух сетов - boolean checkSets(Set<String> s1, Set<String> s2)
// - использовать любые операции кроме Set.equals().
// 2. * Напишите в CustomArrayDeque итератор для перебора в обратном направлении.
// 3. * Напишите в CustomArrayDeque итератор для перебора по убыванию значений элементов.
// 4. *  Напишите  функцию, которая ищет самую длинную последовательность четных чисел
// (расположенных последовательно по порядку) в передаваемом в нее List<Integer>
// и возвращает ее в виде Collection<Integer>. Пример [1,2,5,6,8,7,4] -> [6,8].

import java.util.HashSet;
import java.util.Set;

public class SetComparison {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("Hello");
        s1.add("world");
        s1.add("!");
        Set<String> s2 = new HashSet<>();
        s2.add("Hello");
        s2.add("world");
        s2.add("!");
        System.out.println(checkSets(s1, s2));

    }

    private static boolean checkSets(Set<String> s1, Set<String> s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        boolean res = false;
        if (s1.size() == s2.size()) {
            StringBuilder temp = new StringBuilder();
            for (String s : s1) {
                res = s2.contains(s);
            }
        }
        return res;
    }
}
