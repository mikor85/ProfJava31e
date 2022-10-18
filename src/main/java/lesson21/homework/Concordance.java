package lesson21.homework;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Concordance {
    public static void main(String[] args) {
        List<String> lines = List.of(
                "By the  old Moulmein Pagoda, lookin' lazy at the sea,",
                "There's a Burma girl a-settin', and I know she thinks o' me;",
                "For the wind is in the palm-trees, and the temple-bells they say:",
                "Come you back, you British soldier; come you back to Mandalay! ",
                "Come you back to Mandalay,",
                "Where the old Flotilla lay:",
                "Can't you 'ear their paddles chunkin' from Rangoon to Mandalay ?",
                "On the road to Mandalay,",
                "Where the flyin'-fishes play,",
                "An' the dawn comes up like thunder outer China 'crost the Bay!"
        );

        TreeMap<String, Set<Integer>> result = new TreeMap<>(getConcordance(lines));
        System.out.println(
                result
        );

    }

    // *** Напишите функцию, которая получает на вход список строк и возвращает
    // Map ключ которой это слово, а значение это список номеров строк,
    // в которых это слово встречалось (concordance)
    public static Map<String, Set<Integer>> getConcordance(List<String> lines) {
        // вычистить строки от пунктуации
        // как-то сделать пары из строки и номера строки
        // номер строки -> строка
        // слово        -> номер строки


//        SimpleEntry<String, Integer> pa = new SimpleEntry<>("hello", 33);
//        pa.getValue()  // 33
//        pa.getKey()    // "hello"


        Map<String, List<SimpleEntry<String, Integer>>>
                mapWordToLineNumber =
                IntStream.range(0, lines.size())  // int
                        // .boxed int -> Integer
                        .mapToObj(i -> new SimpleEntry<Integer, String>(i, lines.get(i)))  // Pair<Integer, String>
                        // pair.getKey()
                        // pair.getValue()
                        .flatMap(pair ->
                                Arrays.stream(pair
                                                .getValue()  // каждая строка
                                                .toLowerCase()
                                                .replaceAll("\\p{Punct}", "")  // удаляем пунктуацию
                                                .split("\\s+"))   // разбиваем по пробелу
                                        .map(word -> new SimpleEntry<String, Integer>(word, pair.getKey()))
                        )  // SimpleEntry<String, Integer>
                        .collect(Collectors.groupingBy(
                                entry -> entry.getKey()
                        ));  // Map<String, List<SimpleEntry<String, Integer>>>

        List<SimpleEntry<String, Set<Integer>>> result =
                mapWordToLineNumber.entrySet().stream()
                        .map(pair -> new SimpleEntry<String, Set<Integer>>(
                                pair.getKey(),
                                pair.getValue().stream().map(SimpleEntry::getValue).collect(Collectors.toCollection(TreeSet::new)))
                        )
                        .sorted(Map.Entry.comparingByKey())
                        .toList();

        // System.out.println(result);


        return result.stream().collect(Collectors.toMap(
                SimpleEntry::getKey,
                SimpleEntry::getValue
        ));
    }

}
