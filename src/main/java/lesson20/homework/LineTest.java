package lesson20.homework;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Напишите функцию, которая принимает на вход список строк - например, строчки из книги.
// Функция должна подсчитать количество уникальных слов в списке.
// Считаем что слова отделяются друг от друга пробелами.
public class LineTest {
    public static void main(String[] args) {

        List<String> lines = Arrays.asList(
                "Духовной жаждою томим,",
                "В пустыне мрачной я влачился, —",
                "И шестикрылый серафим",
                "На перепутье мне явился.",
                "Перстами легкими как сон",
                "Моих зениц коснулся он.",
                "Отверзлись вещие зеницы,",
                "Как у испуганной орлицы.",
                "Моих ушей коснулся он, —",
                "И их наполнил шум и звон:",
                "И внял я неба содроганье,"
        );


        System.out.println(countUniqueWords(lines));

    }

    public static long countUniqueWords(Collection<String> list) {
        return
                list.stream()
                        .map(s -> s.replaceAll("[—.,:-]", ""))
                        .map(s -> s.replaceAll("\s+", " "))
                        .map(String::toLowerCase)
                        .flatMap(s -> Arrays.stream(s.split(" ")))
                        .distinct()
                        .count();

    }

    public static int getUniqueWords(List<String> stringsList) {
        Set<String> result =
                stringsList.stream()
                        .flatMap(s -> Stream.of(s.split(" ")))
                        .map(String::toLowerCase)
                        .collect(Collectors.toSet());
        return result.size();
    }
}
