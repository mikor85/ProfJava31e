package lesson2.homework.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaTester {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        l.add(123);
        l.add("Hello");

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello world");
        System.out.println(stringList.size());
        System.out.println(stringList.get(0));
        stringList.remove(0);
        System.out.println(stringList.size());

        PizzaOrder order1 = new PizzaOrder();
        order1.add(new Pizza("small", 1, 0, 1));
        order1.add(new Pizza("large", 0, 0, 1));
        order1.add(new Pizza("medium", 0, 2, 0));

        System.out.println(order1.calcTotalPrice());
    }
}
