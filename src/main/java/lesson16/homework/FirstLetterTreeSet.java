package lesson16.homework;

// ДЗ проф ява:
// 2. ** Написать метод, принимающий на вход список слов и возвращающий TreeMap
// с ключами в виде первой буквы и отсортированного по возрастанию TreeSet<String>
// со словами в которых эта буква первая.
// Пример: ["Hello", "Hell", "World"] -> {"H": ["Hell", "Hello"],  "W":["World"]}.
// TreeMap<String, TreeSet<String>>.

import java.util.TreeMap;
import java.util.TreeSet;

public class FirstLetterTreeSet {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hello", "Hell", "World"};
        System.out.println(getSortedTreeSet(strings));
    }

    public static TreeMap<String, TreeSet<String>> getSortedTreeSet(String[] strings) {
        StringBuilder firstLetter = new StringBuilder();
        TreeSet<String> stringTreeSet = new TreeSet<>();
        TreeMap<String, TreeSet<String>> resultTreeMap = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            //TODO

        }

        return resultTreeMap;
    }
}
