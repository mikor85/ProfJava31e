package lesson44.homework;

import java.util.List;

public class GetPalindrome {

    public static void getPalindrome(List<String> string) {
        string.stream()
                .filter(s -> {
                    StringBuilder sb = new StringBuilder(s).reverse();
                    return s.replaceAll(" ", "")
                            .equalsIgnoreCase(sb.toString().replaceAll(" ", ""));
                }).forEach(System.out::println);
    }
}