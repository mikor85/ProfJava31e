package lesson10.homework;

// ДЗ проф ява:
// 1. Напишите функцию, которая принимает на вход строку,
// разбивает ее на слова по пробелу и на выход отдает коллекцию слов-дубликатов.
// Т.е. слов, которые присутствуют в строке более чем один раз.
// Пример: "части веб-сайтов которые вы посетили. Узнайте, как вы можете удалить его,
// чтобы исправить проблемы с работой и отображением веб-сайтов" -> ["веб-сайтов", "вы"].

// 2. * Напишите функцию, которая принимает на вход строку,
// разбивает ее на слова по пробелу и выводит на экран каждое слово и
// сколько раз это слово встретилось в строке.
// Пример: "один раз это один раз" распечатать "один":2, "раз":2, "это":1.

import java.util.*;

public class WordsCounters {
    public static void main(String[] args) {

        System.out.println("Task Nr.1:");
        String stringTask1 = "Кэш Firefox временно хранит части веб-сайтов, " +
                "которые вы посетили. Узнайте, как вы можете удалить его, " +
                "чтобы исправить проблемы с работой и отображением веб-сайтов.";
        System.out.println(getDuplicateList(stringTask1));
        System.out.println("----------");
        System.out.println(getDuplicates(stringTask1));
        System.out.println("----------");

        System.out.println("Task Nr.2:");
        String stringTask2 = "один раз это один раз";
        String stringTask3 = "one two tree one";
        wordsCounter(stringTask2);
        System.out.println("----------");
        stringWordsCounter(stringTask2);

    }

    public static Collection<String> getDuplicates(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\.", "");
        s = s.replaceAll(",", "");
        String[] tokens = s.split(" ");
        //System.out.println(Arrays.toString(tokens));
        Set<String> words = new HashSet<>();       // список слов
        Set<String> duplicates = new HashSet<>();  // список дубликатов
        for (String w : tokens) {
            if (words.contains(w)) {
                duplicates.add(w);
            } else {
                words.add(w);
            }
        }
        return duplicates;
    }


    // Task Nr.1
    private static Collection<String> getDuplicateList(String string) {
        List<String> words = new ArrayList<>(Arrays.asList(deleteCharsFromString(string).split("\\s")));
        List<String> temp = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();
        for (String word : words) {
            if (temp.contains(word)) {
                duplicates.add(word);
            }
            temp.add(word);
        }
        return duplicates;
    }

    private static String deleteCharsFromString(String string) {
        Set<Character> chars = new HashSet<>(Arrays.asList(',', '.', ':', ';'));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (!chars.contains(string.charAt(i))) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    // Пример: "один раз это один раз" распечатать "один":2, "раз":2, "это":1.
    // Task Nr.2

    private static void stringWordsCounter(String s) {
        Set<Word> w = new HashSet<>();
        for (String a : s.split(" ")) {
            Word d = new Word(a);
            if (w.contains(d)) {
                d = findWord(w, d);  // поиск Word с ключом 'a' в хэше 'w'
            }
            d.count++;  // в любом случае увеличиваем кол-во слов на единицу
            w.add(d);
        }
        for (Word www : w) {
            System.out.println(www);
        }

    }

    private static Word findWord(Set<Word> w, Word d) {
        for (Word ww : w) {
            if (ww.equals(d)) {
                return ww;
            }
        }
        return null;
    }

    public static class Word {
        public String key;
        public int count = 0;

        public Word(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key + ": " + count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            // if (count != word.count) return false;  // по кол-ву сравнивать нам не нужно
            return Objects.equals(key, word.key);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            // result = 31 * result + count;
            return result;
        }
    }

    // Мой вариант реализации
    private static void wordsCounter(String string) {
        List<String> words = new ArrayList<>(Arrays.asList(string.split("\\s")));
        Set<String> newWords = new HashSet<>(words);
        for (int i = 0; i < newWords.size(); i++) {
            StringBuilder sB = new StringBuilder(words.get(i));
            int count = 0;
            for (String word : words) {
                if (sB.toString().equals(word)) {
                    count++;
                }
            }
            if (i < newWords.size() - 1) {
                System.out.print(sB + ": " + count + ", ");
            } else System.out.print(sB + ": " + count + ".");
        }
        System.out.println();
    }
}
