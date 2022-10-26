package lesson24.homework;

// Найдите самое длинное слово в текстовом файле

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class longestWordInTxtFile {
    public static void main(String[] args) {
        File file = new File("D:\\Mitrof\\web\\Java_projects\\ProfJava31e\\src\\main\\java\\lesson24\\homework\\hw.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println("longest word in file " + "'" +
                file.getName() + "'" + " is: " +
                getTheLongestWordFromTxtFile(file));
    }

    public static String getTheLongestWordFromTxtFile(File file) {
        StringBuilder res = new StringBuilder();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            res = new StringBuilder(String.valueOf(
                    bufferedReader.lines()
                            .flatMap(s -> Stream.of(s.split(" ")))
                            .max(Comparator.comparing(String::length))
                            .stream()
                            .collect(Collectors.toList())
            ));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return res.toString();
    }
}