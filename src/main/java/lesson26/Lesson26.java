package lesson26;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Lesson26 {
    public static void main(String[] args) throws IOException {
        String name = "Max";
        System.out.println(((Object) name).hashCode());

        String newName = name;
        System.out.println(newName == name);

        name += " Kotkov";

        System.out.println(newName == name);


        // оптимизирован под скорость работы в одном потоке
        StringBuilder builder = new StringBuilder("Max");

        StringBuilder builder1 = builder;
        System.out.println(builder == builder1);
        builder.append(" Kotkov");
        System.out.println(builder == builder1);


        // поддерживает многопоточное использование
        StringBuffer buffer1 = new StringBuffer("Max");

//        System.out.println("-----StringBuilder and StringBuffer time comparing-----");
//        for (int i = 0; i < 5; i++) {
//            StringBuilder max = new StringBuilder();
//            check(max);
//        }
//        System.out.println("----------");
//        for (int i = 0; i < 5; i++) {
//            StringBuffer masha = new StringBuffer();
//            check(masha);
//        }

        List<String> names = List.of("Max", "Aleksander", "Daria", "Masha");
        StringBuilder b = new StringBuilder();

        names.forEach(
                b::append
        );

        System.out.println(b);


    }

    public static void check(Appendable builder) throws IOException {
        Random random = new Random();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            builder.append("").append(String.valueOf(random.nextDouble()));
        }
        long after = System.currentTimeMillis();

        System.out.println("time: " + (after - before));
    }
}
