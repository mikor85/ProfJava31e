package lesson21.homework;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Напишите функцию, которая получает на вход список строк и возвращает Map.
// Ключ - это слово, а значение это список номеров строк, в которых это слово встречалось (concordance).
public class ConcordanceMy {
    public static void main(String[] args) {
        ConcordanceMy concordance = new ConcordanceMy();
        List<String> stringList = List.of(
                "Окружен рабов толпой,",
                "С грозным деспотизма взором,",
                "Афедрон ты жирный свой",
                "Подтираешь коленкором;",
                "Я же грешную дыру",
                "Не балую детской модой",
                "И Хвостова жесткой одой,",
                "Хоть и морщуся, да тру."
        );
        //concordance.getStringConcordance(stringList);

        List<String> listTemp =
                stringList.stream()
                        .map(s -> s.replaceAll("\\p{Punct}", ""))
                        .map(String::toLowerCase).toList();
        System.out.println(listTemp);

        Map<Integer, String> counterToStr = IntStream.range(0, listTemp.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), listTemp::get));
        System.out.println(counterToStr);

        List<AbstractMap.SimpleEntry<String, Integer>> worldToLineNumber =
                counterToStr.entrySet().stream()
                        .flatMap(
                                entry -> Arrays.stream(entry.getValue().split(" "))
                                        .map(string -> new AbstractMap.SimpleEntry<String, Integer>(string, entry.getKey())))
                        .toList();

        System.out.println(worldToLineNumber);

    }

    private Map<String, List<Integer>> getStringConcordance(List<String> stringList) {
        List<String> listTemp =
                stringList.stream()
                        .map(s -> s.replaceAll("\\p{Punct}", ""))
                        .map(String::toLowerCase).toList();
        System.out.println(listTemp);

        Map<Integer, String> counterToStr = IntStream.range(0, listTemp.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), listTemp::get));
        System.out.println(counterToStr);

        List<AbstractMap.SimpleEntry<String, Integer>> worldToLineNumber =
                counterToStr.entrySet().stream()
                        .flatMap(
                                entry -> Arrays.stream(entry.getValue().split(" "))
                                        .map(string -> new AbstractMap.SimpleEntry<String, Integer>(string, entry.getKey())))
                        .toList();

        return null;
    }
}