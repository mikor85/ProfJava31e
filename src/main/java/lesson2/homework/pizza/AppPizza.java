package lesson2.homework.pizza;

import java.util.ArrayList;
import java.util.List;

public class AppPizza {
    public static void main(String[] args) {

        Pizza p1 = new Pizza("small", 2, 1, 0);
        System.out.println("----------");
        System.out.println(p1);

        Pizza p2 = new Pizza("medium", 2, 2, 2);
        System.out.println("----------");
        System.out.println(p2);
    }
}
