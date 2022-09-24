package lesson15.hashMap;

public class MapTester {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("Moldova", "Kishinev");
        map.put("Hungary", "Budapest");
        map.put("Latvia", "Riga");
        map.put("Germany", "Berlin");
        map.put("Belarus", "Minsk");
        map.put("Russia", "Moscow");
        map.put("France", "Paris");
        map.put("Spain", "Madrid");
        map.put("Sweden", "Stockholm");
        map.put("Italy", "Rome");
        System.out.println(map.size());

        System.out.println(map.get("Moldova"));

        System.out.println(map.contains("Moldova"));
        System.out.println(map.contains("Germany"));
        System.out.println(map.contains("Hungary"));

        System.out.println(map.remove("Germany"));
        System.out.println(map.size());
        System.out.println(map.contains("Germany"));

        System.out.println(map.remove("Russia"));
        System.out.println(map.size());
        System.out.println(map.contains("Russia"));

        System.out.println(map.remove("Spain"));
        System.out.println(map.size());
        System.out.println(map.contains("Spain"));

    }
}
