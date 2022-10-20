package lesson23;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ResourceReader {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
        // bufferedReader.lines()
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/text.txt"));
        lines.forEach(System.out::println);

        Scanner scanner = new Scanner(new FileInputStream("src/main/resources/text.txt"));

        // просуммируйте цифры в файле "src/main/resources/text.txt"
        int sum = 0;
        while (scanner.hasNext()) {
            sum += scanner.nextInt();
        }
        System.out.println("sum = " + sum);

        int sum2 =
        lines.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);
    }
}