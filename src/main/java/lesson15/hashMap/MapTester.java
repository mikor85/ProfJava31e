package lesson15.hashMap;

public class MapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Kishinev");    // source[bucket] = 0  ->  newSource[bucket] = 0
        map.put("Hungary", "Budapest");    // source[bucket] = 2  ->  newSource[bucket] = 6
        map.put("Sweden", "Stockholm");
        map.put("Poland", "Warsaw");
        map.put("Estonia", "Tallinn");

        System.out.println(map.get("Moldova"));
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.getInsideArrayLength());
        map.remove("Hungary");
        System.out.println(map);

        MyGenericHashMap<String, String> cities = new MyGenericHashMap<>();
        cities.put("GB", "London");
        System.out.println(cities.get("GB"));



//        System.out.println("Hungary hashCode = " + "Hungary".hashCode());

//        map.put("Latvia", "Riga");         // source[bucket] = 1  ->  newSource[bucket] = 1
//        System.out.println("Latvia hashCode = " + "Latvia".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Germany", "Berlin");      // source[bucket] = 3  ->  newSource[bucket] = 3
//        System.out.println("Germany hashCode = " + "Germany".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Belarus", "Minsk");       // source[bucket] = 0  ->  newSource[bucket] = 0
//        System.out.println("Belarus hashCode = " + "Belarus".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Russia", "Moscow");     // source[bucket] = 1  ->  newSource[bucket] = 5
//        System.out.println("Russia hashCode = " + "Russia".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("France", "Paris");      // source[bucket] = 3  ->  newSource[bucket] = 3
//        System.out.println("France hashCode = " + "France".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Spain", "Madrid");      // source[bucket] = 1  ->  newSource[bucket] = 1
//        System.out.println("Spain hashCode = " + "Spain".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Sweden", "Stockholm");  // source[bucket] = 0  ->  newSource[bucket] = 4
//        System.out.println("Sweden hashCode = " + "Sweden".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        map.put("Italy", "Rome");        // source[bucket] = 3  ->  newSource[bucket] = 3
//        System.out.println("Italy hashCode = " + "Italy".hashCode());
//        System.out.println("Map size = " + map.size());
//
//        System.out.println(map.get("Moldova"));
//
//        System.out.println(map.contains("Moldova"));
//        System.out.println(map.remove("Moldova"));
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
