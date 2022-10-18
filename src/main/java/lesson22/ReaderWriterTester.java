package lesson22;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderWriterTester {
    public static void main(String[] args) {
        /*
        String line = "";
        List<String> lines = new ArrayList<>();
        System.out.println("Enter lines unit stop");
        Scanner keyBoard = new Scanner(System.in);
        do {
            line = keyBoard.nextLine();
            lines.add(line);
        } while (!line.equals("stop"));
        try (FileWriter fileWriter = new FileWriter("lines.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String s : lines) {
                bufferedWriter.write(s);
            }
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
         */

        try (FileReader fileReader = new FileReader("lines.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}