package lesson23;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FilesAndDirs {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        System.out.println(homeDir);

        String separator = System.getProperty("file.separator");

        File home = new File(homeDir);
        // home.exists();
        String path = home.getAbsolutePath();
        boolean isFile = home.isFile();
        System.out.println("path: " + path);
        System.out.println("isFile: " + isFile);
        Arrays.stream(Objects.requireNonNull(home.list(
                        // new FilenameFilter()
                        (dir, name) -> name.endsWith("ini")
                )))
                .sorted()
                .forEach(
                        f -> {
                            File newFile = new File(path + separator + f);
                            long size = newFile.length();
                            String type = newFile.isFile() ? "f" : "d";
                            System.out.println(newFile.getAbsolutePath() + " " + type + " " + size);
                        }
                );

        // распечатать properties
        // https://mkyong.com/java/how-to-list-all-system-properties-key-and-value-in-java/


    }
}
