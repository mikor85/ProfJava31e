package lesson2.homework.pizza;

public class AppPizza {
    public static void main(String[] args) {

        Pizza p1 = new Pizza("small", 2, 1, 0);
        Pizza p2 = new Pizza("medium", 2, 2, 2);
        Pizza p3 = new Pizza("large", 3, 1, 1);

        PizzaOrder pOrder1 = new PizzaOrder();
        pOrder1.add(p1);
        pOrder1.add(p2);
        pOrder1.add(p3);
        System.out.println("---------------");
        pOrder1.printOrderList();
    }
}
