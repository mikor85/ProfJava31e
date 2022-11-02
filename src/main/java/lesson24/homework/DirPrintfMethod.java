package lesson24.homework;

// 3. ** Напишите функцию-аналог dir или ls -l - должна принимать на вход путь к директории.
// В выводе должны присутствовать типы файлов (d для директории и - для обычного файла), размер файла и название.
// Также добавьте правильный формат строк (printf(...)).

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Objects;
import static java.lang.System.out;

public class DirPrintfMethod {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Mitrof\\web\\Java_projects\\ProfJava31e";
        printDir(path);
        System.out.println("----------");
        dir(path);
    }

    public static void dir(String d) throws IOException {
        File dir = new File(d);
        // получаем полный путь к директории
        String dirAbsPath = dir.getAbsolutePath();
        String sep = File.separator;
        String[] file = dir.list();
        for (int i = 0; i < file.length; i++) {
            String name = file[i];
            Path path = Path.of(dirAbsPath + sep + name);
            UserPrincipal user = Files.getOwner(path);
            out.print(
                    Files.isDirectory(path) ? "d" : "-"
            );
            out.print(
                    Files.isReadable(path) ? "r" : "-"
            );
            out.print(
                    Files.isWritable(path) ? "w" : "-"
            );
            out.print(
                    Files.isExecutable(path) ? "x" : "-"
            );
            out.printf(" %15s %10d %30s\n", user.getName(), Files.size(path), name);
        }
    }

    // My method
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