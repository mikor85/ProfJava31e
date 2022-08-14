package lesson4.animals;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract String greets();

    // public abstract void greets();

    // public abstract void greets(Dog dog);

    // public abstract void greets(BigDog dog);
}
