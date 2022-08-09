package lesson2.homework.pizza;

// Создайте класc Pizza, поля size типа String (с возможными значениями "small", "medium", "large"),
// cheese:int, pepperoni:int,ham:int=0.
// Добавьте конструктор вида Pizza(String size, int cheese, int pepperoni, int ham), геттеры,сеттеры и toString.
// Добавьте метод calcPrice(): int - маленькая 10, средняя 12, большая 14 и каждый топпинг по 2.
// Создайте класс PizzaOrder куда можно будет добавлять пиццу  методом add(Pizza) и
// напишите метод calcTotalPrice(): int который вычислит всю сумму заказа для всех пиц.

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
