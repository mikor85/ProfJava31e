package lesson24.homework;

// 3. ** Напишите функцию-аналог dir или ls -l - должна принимать на вход путь к директории.
// В выводе должны присутствовать типы файлов (d для директории и - для обычного файла), размер файла и название.
// Также добавьте правильный формат строк (printf(...)).

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DirPrintfMethod {
    public static void main(String[] args) {
        String path = "D:\\Mitrof\\web\\Java_projects\\ProfJava31e";
        printDir(path);
    }

    public static void printDir(String path) {
        File file = new File(path);
        Arrays.stream(Objects.requireNonNull(file.list()))
                .sorted()
                .forEach(
                        f -> {
                            File newFile = new File(f);
                            long size = newFile.length();
                            String type = newFile.isDirectory() ? "d" : "f";
                            System.out.printf("type = %s  |  size = %4d  |  File: %15s%n", type, size, f);
                        }
                );
    }
}