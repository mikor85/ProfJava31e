package lesson4.animals;

public class AppAnimals {
    public static void main(String[] args) {
        Cat c = new Cat("Vasya");
        System.out.print(c.getName());
        c.greets();

        Dog d = new Dog("Sharik");

    }
}
