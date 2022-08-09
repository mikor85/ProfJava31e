package lesson3.enums;

public class Pizza {
//    private String size;
    private PizzaSize size;
    private int cheese, pepperoni, ham;

    //public Pizza(String size, int cheese, int pepperoni, int ham) {
    public Pizza(PizzaSize size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }


    public PizzaSize getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = PizzaSize.valueOf(size);
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
            case SMALL -> price += 10 + (cheese + pepperoni + ham) * 2;
            case MEDIUM -> price += 12 + (cheese + pepperoni + ham) * 2;
            case LARGE -> price += 14 + (cheese + pepperoni + ham) * 2;
        }
        return price;
    }
}
