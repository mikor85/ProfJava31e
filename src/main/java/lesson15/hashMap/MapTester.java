package lesson15.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapTester {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();

        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Kishinev");    // source[bucket] = 0  ->  newSource[bucket] = 0
        System.out.println("Moldova hashCode = " + "Moldova".hashCode());
        map.put("Hungary", "Budapest");    // source[bucket] = 2  ->  newSource[bucket] = 6
        System.out.println("Hungary hashCode = " + "Hungary".hashCode());
        map.put("Latvia", "Riga");         // source[bucket] = 1  ->  newSource[bucket] = 1
        System.out.println("Latvia hashCode = " + "Latvia".hashCode());
        System.out.println("Map size = " + map.size());
        System.out.println("sourceLength = " + map.sourceLength);
        map.put("Germany", "Berlin");      // source[bucket] = 3  ->  newSource[bucket] = 3
        System.out.println("Germany hashCode = " + "Germany".hashCode());
        System.out.println("Map size = " + map.size());
        System.out.println("sourceLength = " + map.sourceLength);
        map.put("Belarus", "Minsk");       // source[bucket] = 0  ->  newSource[bucket] = 0
        System.out.println("Belarus hashCode = " + "Belarus".hashCode());
        System.out.println("Map size = " + map.size());
        System.out.println("sourceLength = " + map.sourceLength);
//        map.put("Russia", "Moscow");     // source[bucket] = 1  ->  newSource[bucket] = 5
        System.out.println("Russia hashCode = " + "Russia".hashCode());
//        System.out.println("Map size = " + map.size());
//        System.out.println("sourceLength = " + map.sourceLength);
//        map.put("France", "Paris");      // source[bucket] = 3  ->  newSource[bucket] = 3
        System.out.println("France hashCode = " + "France".hashCode());
//        System.out.println("Map size = " + map.size());
//        System.out.println("sourceLength = " + map.sourceLength);
//        map.put("Spain", "Madrid");      // source[bucket] = 1  ->  newSource[bucket] = 1
        System.out.println("Spain hashCode = " + "Spain".hashCode());
//       System.out.println("Map size = " + map.size());
//        System.out.println("sourceLength = " + map.sourceLength);
//        map.put("Sweden", "Stockholm");  // source[bucket] = 0  ->  newSource[bucket] = 4
        System.out.println("Sweden hashCode = " + "Sweden".hashCode());
//        System.out.println("Map size = " + map.size());
//        System.out.println("sourceLength = " + map.sourceLength);
//        map.put("Italy", "Rome");        // source[bucket] = 3  ->  newSource[bucket] = 3
        System.out.println("Italy hashCode = " + "Italy".hashCode());
//        System.out.println("Map size = " + map.size());
//        System.out.println("sourceLength = " + map.sourceLength);
//
//        System.out.println(map.get("Moldova"));
//
//        System.out.println(map.contains("Moldova"));
//        System.out.println(map.contains("Germany"));
//        System.out.println(map.contains("Hungary"));
//
//        System.out.println(map.remove("Germany"));
//        System.out.println(map.size());
//        System.out.println(map.contains("Germany"));
//
//        System.out.println(map.remove("Russia"));
//        System.out.println(map.size());
//        System.out.println(map.contains("Russia"));
//
//        System.out.println(map.remove("Spain"));
//        System.out.println(map.size());
//        System.out.println(map.contains("Spain"));

    }
}
