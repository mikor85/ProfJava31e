package lesson4.animals;

public class Cat extends Animal{
    private String name;

    public Cat(String name) {
        super(name);
    }

    @Override
    public String greets() {
        return "Meouw";
    }

    public String getName() {
        return name;
    }

//    @Override
//    public void greets() {
//        System.out.println("Meouw");
//    }
//
//    @Override
//    public void greets(Dog dog) {
//        System.out.println("Meouw");
//    }
//
//    @Override
//    public void greets(BigDog dog) {
//        System.out.println("Meouw");
//    }
}
