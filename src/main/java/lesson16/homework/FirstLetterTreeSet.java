package lesson16.homework;

// ДЗ проф ява:
// 2. ** Написать метод, принимающий на вход список слов и возвращающий TreeMap
// с ключами в виде первой буквы и отсортированного по возрастанию TreeSet<String>
// со словами в которых эта буква первая.
// Пример: ["Hello", "Hell", "World"] -> {"H": ["Hell", "Hello"],  "W":["World"]}.
// TreeMap<String, TreeSet<String>>.

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstLetterTreeSet {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hello", "Hell", "World"};
        System.out.println(getTreeMap(strings));
    }

    public static TreeMap<String, TreeSet<String>> getFrequency(List<String> words) {
        TreeMap<String, TreeSet<String>> res = new TreeMap<>();
        // в цикле пробежаться по словам
        for (String w : words) {
            // получить с каждого первую букву
            String key = "" + w.toCharArray()[0];
            // по букве получить из ret TreeSet
            TreeSet<String> vals = res.get(key);
            // если TreeSet null то создать новый
            if (vals == null)
                vals = new TreeSet<>();
            // добавить слово в TreeSet
            vals.add(w);
            // обновить пару первая буква -> TreeSet в res
            res.put(key, vals);
        }
        // возвратить res
        return res;
    }


    // My realization
    public static TreeMap<String, TreeSet<String>> getTreeMap(String[] strings) {
        TreeMap<String, TreeSet<String>> resultTreeMap = new TreeMap<>();
        for (String string : strings) {
            StringBuilder firstLetter = new StringBuilder();
            TreeSet<String> currentStringTreeSet = new TreeSet<>();
            firstLetter.append(string.charAt(0));
            if (resultTreeMap.containsKey(firstLetter.toString())) {
                currentStringTreeSet = resultTreeMap.get(firstLetter.toString());
            }
            currentStringTreeSet.add(string);
            resultTreeMap.put(firstLetter.toString(), currentStringTreeSet);
        }
        return resultTreeMap;
    }
}