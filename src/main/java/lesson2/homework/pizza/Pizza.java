package lesson2.homework.pizza;

// Создайте класc Pizza, поля size типа String (с возможными значениями "small", "medium", "large"),
// cheese:int, pepperoni:int,ham:int=0.
// Добавьте конструктор вида Pizza(String size, int cheese, int pepperoni, int ham), геттеры,сеттеры и toString.
// Добавьте метод calcPrice(): int - маленькая 10, средняя 12, большая 14 и каждый топпинг по 2.
// Создайте класс PizzaOrder куда можно будет добавлять пиццу  методом add(Pizza) и
// напишите метод calcTotalPrice(): int который вычислит всю сумму заказа для всех пиц.

import java.util.InputMismatchException;

public class Pizza {
    private String size;
    private int cheese, pepperoni, ham;
    private int price;

    public Pizza(String size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
        this.price = calcPrice();
        if (!checkSize()) {
            System.out.println("Размер пиццы указан неверно");
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(int pepperoni) {
        this.pepperoni = pepperoni;
    }

    public int getHam() {
        return ham;
    }

    public void setHam(int ham) {
        this.ham = ham;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza's info: " + '\n' +
                "Size: " + size + '\n' +
                "Cheese: " + cheese + " pcs." + '\n' +
                "Pepperoni: " + pepperoni + " pcs." + '\n' +
                "Ham: " + ham + " pcs." + '\n' +
                "Price: " + price + "EUR";
    }

    public boolean checkSize() {
        return size.equals("small") || size.equals("medium") || size.equals("large");
    }

    public int calcPrice() {
        int price = 0;
        switch (size) {
            case "small" -> price += 10 + (cheese + pepperoni + ham) * 2;
            case "medium" -> price += 12 + (cheese + pepperoni + ham) * 2;
            case "large" -> price += 14 + (cheese + pepperoni + ham) * 2;
        }
        return price;
    }
}
