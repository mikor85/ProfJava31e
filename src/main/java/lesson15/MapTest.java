package lesson15;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        // Data structure 'Map'. Object.hashcode, HashMap implementation.
        // тип ключа, тип значения
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Germany", "Berlin");
        System.out.println(capitals.get("Germany"));
        System.out.println(capitals.get("Belgium"));
        capitals.put("Germany", "Frankfurt");
        System.out.println(capitals.get("Germany"));
        capitals.remove("Germany");
        System.out.println(capitals.get("Germany"));
        System.out.println(capitals.size());
        capitals.put("GB", "London");
        Iterator<Map.Entry<String, String>> it = capitals.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("----------");
        // Task Nr.1:
        String string = "performs the given action for each entry in this map until all entries have been processed or the action throws an exception";
        printWordFrequency(string);

        // LinkedHashMap на основе Hash таблицы, элементы возвращаются в порядке вставки.
        // TreeMap элементы отсортированы по компаратору

        /*
            class Entry{
                K key;
                V value;
                Entry next;
            }
         */

        // хэш - отображение объекта в какое-то целое число
        // Хэш функция, у нас есть ключ, и он возвращает целое число - int hashCode():
        // vasya -> 123
        // masha -> 468
        // konstantin -> 123
        // эквивалентность ключей - это означает равенство хэщ-кодов,
        // если хэщ-коды одинаковые - это не значит, что ключи эквивалентны.
        // vasya.hashCode() == konstantin.hashCode() != vasya.equals(konstantin)=true
        // vasya.equals(konstantin)=true -> vasya.hashCode() == konstantin.hashCode()
    }

    // напишите функцию, принимающую строку и распечатывающую частоту встречающихся в ней слов,
    // слова разделяются пробелами.
    public static void printWordFrequency(String s) {
        Map<String, Integer> words = new HashMap<>();
        String[] w = s.split(" ");
        for (String word : w) {
            Integer number = words.get(word);
            if (number != null) {
                words.put(word, ++number);
            } else {
                words.put(word, 1);
            }
        }
        Set<String> keys = words.keySet();
        for (String word : keys) {
            System.out.println(word + ":" + words.get(word));
        }
    }
}
