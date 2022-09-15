package lesson13;

import java.util.*;

public class Lesson13 {
    // Comparing objects in Java. Comparator, Comparable. Method sort.
    public static void main(String[] args) {
        String[] groups = new String[]{"Sex Pistols", "Ramones", "Aerosmith", "Rolling Stones"};
        // boolean equals(Object o);
        // String s1 = "...";
        // String s2 = "...";
        // s1.compareTo(s2) - возвращает 0, если s1 и s2 эквивалентны
        // -1 если s2 больше чем s1
        //  1 если s2 меньше чем s1
        System.out.println(Arrays.toString(groups));
        Arrays.sort(groups);
        System.out.println(Arrays.toString(groups));

        List<Player> team = new ArrayList<>(
                Arrays.asList(
                        new Player(14, "Sam", 24),
                        new Player(16, "Alexander", 27),
                        new Player(10, "John", 34),
                        new Player(27, "Sam", 19),
                        new Player(12, "Michael", 37)
                )
        );
//        Collections.sort(new ArrayList<String>(Arrays.asList("One", "Two", "Three")));
//        System.out.println(team);
//        Collections.sort(team);
//        System.out.println("After Comparable " + team);
//        Collections.sort(team, new PlayerRankComparator());
//        System.out.println("rank Comparator " + team);
//        Collections.sort(team, new Player.PlayerAgeComparator());
//        System.out.println("age Comparator " + team);
//        Collections.sort(team, new Player.PlayerAgeComparator().reversed());
//        System.out.println("age Comparator reversed " + team);

//        Collections.sort(team, new Comparator<Player>() {
//            @Override
//            public int compare(Player o1, Player o2) {
//                return o2.getName().compareTo(o1.getName());
//            }
//        });

        // лямбда выражение
        // SAM Single Access Method
        Collections.sort(team, (o1, o2) -> o2.getName().compareTo(o1.getName()));

        Comparator<Player> reverseName = (o1, o2) -> o2.getName().compareTo(o1.getName());

        System.out.println("name Comparator reversed " + team);

        // отсортировать игроков по их именам по возрастанию и потом по возрасту по убыванию
        // Comparator<Player> ageComparator = (o1, o2) -> o1.getAge() - o2.getAge();

        Comparator<Player> ageComparatorBackwards = (o1, o2) -> Integer.compare(o2.getAge(), o1.getAge());

        team.sort(reverseName.reversed().thenComparing(ageComparatorBackwards));
        System.out.println("name-age reversed Comparator " + team);


        team.sort(
                Comparator.comparing(Player::getAge)
                        .reversed()
                        .thenComparing(Player::getName)
                        .thenComparing(Player::getRank)
        );
    }
}