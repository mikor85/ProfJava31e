package lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class lesson20 {
    public static void main(String[] args) {
        // Java Streams. Flat Map.

        // map пропускает элементы 1->1
        // filter может пропустить от 0 до N элементов
        // flatMap
        // map только трансформирует элемент
        // flatMap и трансформирует и "уплощает"
        // flattening = уплощение

        List<List<String>> list = Arrays.asList(
                Arrays.asList("Max", "Alex"),
                Arrays.asList("Ksenia", "Maria", "Daria")
        );
        list.stream().map(l -> l.contains("a")).forEach(System.out::println);
        list.stream().forEach(System.out::println);

        System.out.println(
                list.stream().flatMap(Collection::stream)
                        .collect(Collectors.toList()));


        int[][] ints = {
                {1, 2, 3},
                {4}
        };
        // превратить в поток целых чисел
        System.out.println("----------");
        System.out.println(
                Arrays.toString(
                        Arrays.stream(ints).flatMapToInt(Arrays::stream).toArray()
                )
        );

        Order grocery = new Order();
        Order utility = new Order();

        grocery.addItems(
                new OrderItem("mango", 5, 1.45),
                new OrderItem("apples", 2, 2.20),
                new OrderItem("Red Bull", 10, 1.3)
        );

        utility.addItems(
                new OrderItem("Diesel", 20, 2.20),
                new OrderItem("Water", 120, 0.97),
                new OrderItem("Electricity", 50, 0.89)
        );

        List<Order> orders = List.of(grocery, utility);
        // посчитайте затраты с помощью flatMap
        double amount =
                orders.stream()
                        .flatMap(order -> order.getItems().stream())
                        .mapToDouble(item -> (item.getQuantity() * item.getUnitPrice()))
                        .sum();
        System.out.println(amount);

    }  // end of main
}

class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void addItems(OrderItem... items) {  // varargs - от 0 до неограниченного кол-ва
        // items - выглядит как массив
        this.items.addAll(Arrays.asList(items));
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

class OrderItem {
    private String title;
    private int quantity;
    private double unitPrice;

    public OrderItem(String title, int quantity, double unitPrice) {
        this.title = title;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
