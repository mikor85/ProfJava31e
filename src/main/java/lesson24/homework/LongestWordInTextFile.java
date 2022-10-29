package lesson24.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInTextFile {
    public static void main(String[] args) {
        // "lines.txt"
        System.out.println(getLongestWord("lines.txt"));
    }

    public static String getLongestWord(String fileName) {
        String result = "";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            result = bufferedReader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .max(Comparator.comparing(String::length))
                    .orElse("");
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
        return result;
    }

}
