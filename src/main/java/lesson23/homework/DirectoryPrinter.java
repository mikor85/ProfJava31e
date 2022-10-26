package lesson23.homework;

import java.io.File;
import java.util.Arrays;

public class DirectoryPrinter {
    public static void main(String[] args) {
        String dir = "D:\\\\Mitrof\\\\CV Kormakov Dmitrij\\\\CV_Дмитрий Кормаков"; // "D:\\Mitrof\\CV Kormakov Dmitrij\\CV_Дмитрий Кормаков"
        String pattern = "r";
        File d = new File(dir);
        String[] files = d.list((dir1, name) -> name.contains(pattern));
        Arrays.stream(files)
                .forEach(
                        System.out::println
                );

        printDirectory("src");
    }

    public static void printDirectory(String path) {
        File d = new File(path);
        String absolutePath = d.getAbsolutePath();
        String sep = File.separator;
        String[] files = d.list();
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            File f = new File(absolutePath + sep + fileName);
            System.out.println(f.getAbsolutePath());
            if (f.isDirectory()) {
                printDirectory(f.getAbsolutePath());
            }
        }
    }
}
