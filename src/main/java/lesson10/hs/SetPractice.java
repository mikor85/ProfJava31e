package lesson10.hs;

import java.util.*;

public class SetPractice {
    public static void main(String[] args) {
        // напишите функцию, которая принимает на вход строку и возвращает
        // Collection<Character> из всех уникальных символов строки

        String word = "Hello world";
        String word2 = "Hello world Hello world Hello world";
        System.out.println(getUniqueChars(word));
        System.out.println(getUniqueCharsTwo(word));
        System.out.println(getUniqueSortedChars(word));
        System.out.println("----------");
        System.out.println(getUniqueChars(word2));
        System.out.println(getUniqueCharsTwo(word2));
        System.out.println(getUniqueSortedChars(word2));

        System.out.println("----------");
        Collection<Character> res = getUniqueChars("Hello world");
        Character[] chars = new Character[res.size()];
        res.toArray(chars);
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        System.out.println("----------");
        List<Character> l = new ArrayList<>(getUniqueChars("Hello world"));
        Collections.sort(l);
        System.out.println(l);

        System.out.println("----------");
        System.out.println(getResults("Hello world"));

    } // end of main

    // Написать функцию, которая принимает на вход стоку и возвращает позиции каждой буквы в этой строке
    //

    static class Result {
        Character c;
        List<Integer> positions = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return Objects.equals(c, result.c);
        }

        @Override
        public int hashCode() {
            return c;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "c=" + c +
                    ", positions=" + positions +
                    '}';
        }
    }

    public static Collection<Result> getResults(String s) {
        Set<Result> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Result r = new Result();
            r.c = c;
            if (res.contains(r)) {
                Iterator<Result> resultIterator = res.iterator();
                while (resultIterator.hasNext()) {
                    Result current = resultIterator.next();
                    if (current.equals(r)){
                        r = current;
                        break;
                    }
                }
            }
            r.positions.add(i);
            res.add(r);
        }
        return res;
    }

    public static Collection<Character> getUniqueSortedChars(String string) {
        Set<Character> chars = new TreeSet<>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }


    public static Collection<Character> getUniqueChars(String string) {
        Set<Character> chars = new HashSet<>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }

    public static Collection<Character> getUniqueCharsTwo(String string) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            result.add(string.charAt(i));
        }
        return result;
    }
}
