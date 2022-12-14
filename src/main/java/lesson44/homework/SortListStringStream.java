package lesson44.homework;

import java.util.Comparator;
import java.util.List;

public class SortListStringStream {

    public static List<String> sortListString(List<String> strings) {

        return strings.stream()
                .sorted(Comparator.comparing(
                        string -> string.substring(1)))
                .toList();
    }
}