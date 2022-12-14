package lesson2.homework.pizza;

public class Pizza {
    private String size;
    private int cheese, pepperoni, ham;

    public Pizza(String size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
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

    @Override
    public String toString() {
        return "Pizza's info: " + '\n' +
                "Size: " + size + '\n' +
                "Cheese: " + cheese + " pcs." + '\n' +
                "Pepperoni: " + pepperoni + " pcs." + '\n' +
                "Ham: " + ham + " pcs." + '\n' +
                "Price: " + calcPrice() + "EUR";
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
