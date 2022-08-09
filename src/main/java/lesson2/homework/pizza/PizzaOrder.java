package lesson2.homework.pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrder {
    private List<Pizza> pizzas = new ArrayList<>();

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "pizzas=" + pizzas +
                '}';
    }

    public void add(Pizza pizza) {
        pizzas.add(pizza);
    }

    public Pizza get(int i) {
        return pizzas.get(i);
    }

    public int calcTotalPrice() {
        int sum = 0;
        for (int i = 0; i < pizzas.size(); i++) {
            sum += get(i).calcPrice();
        }
        return sum;
    }

    public void printOrderList() {
        System.out.println("Order list:");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println("---------------");
            System.out.print(i + 1 + ".:");
            System.out.println(pizzas.get(i));
        }
        System.out.println("______________________");
        System.out.println("| Total price: " + calcTotalPrice() + "EUR |");
        System.out.println("______________________");
    }
}
