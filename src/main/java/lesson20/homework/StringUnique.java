package lesson20.homework;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Напишите функцию, которая принимает на вход список строк - например, строчки из книги.
// Функция должна подсчитать количество уникальных слов в списке.
// Считаем что слова отделяются друг от друга пробелами.
public class StringUnique {
    public static void main(String[] args) {

        List<String> stringsList = Arrays.asList(
                "У лукоморья дуб зелёный",       // 4
                "Златая цепь на дубе том",       // 5
                "И днём и ночью кот учёный",     // 6
                "Всё ходит по цепи кругом",      // 5
                "Идёт направо песнь заводит",    // 4
                "Налево сказку говорит"          // 3
                                                 // 27
        );

        System.out.println(getUniqueWords(stringsList));

    }

    public static int getUniqueWords(List<String> stringsList){
        Set<String> result =
        stringsList.stream()
                .flatMap(s -> Stream.of(s.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        return result.size();
    }
}
