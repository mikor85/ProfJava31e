package lesson23.homework;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

// 2. Напишите функцию, которая принимает на вход путь к директории и строку фрагмент названия
// и распечатывает только файлы, в имени которых есть этот фрагмент.

// 3. ** Напишите функцию, которая принимает на вход путь к директории и распечатывает файлы и директории рекурсивно.
public class DirectoryFileFilter {
    public static void main(String[] args) {
        String dirPath = "D:\\Mitrof\\CV Kormakov Dmitrij\\CV_Дмитрий Кормаков";
        String filter = "docx";
        printFiles(dirPath, filter);

        System.out.println("----------");
        printFilesRec(dirPath);
    }

    // Task Nr.2:
    public static void printFiles(String dirPath, String filter) {
        File directory = new File(dirPath);
        Arrays.stream(Objects.requireNonNull(directory.list(
                        (dir, name) -> name.contains(filter)
                )))
                .sorted()
                .forEach(System.out::println);
    }

    // Task Nr.3:
    public static void printFilesRec(String dirPath) {
        File[] files = new File(dirPath).listFiles();
        if (files != null) {
            printFileName(0, files);
        }
    }

    public static void printFileName(int index, File[] files) {
        if (index >= files.length) {
            return;
        }
        printFileName(index + 1, files);
        System.out.println(files[index].getName());
    }
}