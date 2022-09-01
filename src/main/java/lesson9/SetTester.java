package lesson9;

import java.util.*;

public class SetTester {
    public static void main(String[] args) {
        // Java Set implementation. Exercises.

        // применение - проверка на уникальность;
        // применение - поиск дубликатов;
        // Реализации:
        // HashSet - если правильно подобран алгоритм хэширования и параметры хэш,
        // то операция получения значение из сета может быть O(1).
        // LinkedHashSet - при обходе по итератору элементы возвращаются в порядке вставки.
        // TreeSet - при обходе по итератору элементы возвращаются в порядке сортировки.

        Set<String> groups = new HashSet<>();
        groups.add("Abba");
        groups.add("Guns and Roses");
        groups.add("Pearl Jam");
        groups.add("Abba");
        groups.add("Beatles");
        System.out.println(groups.size());

        System.out.println(groups.contains("Aerosmith"));

        // создать из Set массив
        String[] gr = new String[groups.size()];
        groups.toArray(gr);
        System.out.println(Arrays.toString(gr));

        TreeSet<String> tree = new TreeSet<>(groups);
        for (String s : tree) {
            System.out.println(s);
        }

        // Вычитание, сложение, разность
        TreeSet<String> tree2 = new TreeSet<>(groups);
        // сложение
        tree2.addAll(groups);
        for (String s : tree) {
            System.out.println(s);
        }
        // вычитание
        tree2.removeAll(groups);

        // находятся ли все элементы сета в другом
        tree2.containsAll(groups);

        // общие элементы двух сетах
        tree2.retainAll(groups);


        // ЗАДАЧА
        String[] words = new String[]{"One", "Two", "Three", "Four", "One", "Five", "Three"};
        Set<String> unique = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String w : words) {
            if (!unique.contains(w)) {
                unique.add(w);
            } else {
                duplicates.add(w);
            }
        }
        System.out.println(duplicates);

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(8);
        numbers.add(11);
        numbers.add(4);

        System.out.println(numbers.headSet(5));

    }
}
