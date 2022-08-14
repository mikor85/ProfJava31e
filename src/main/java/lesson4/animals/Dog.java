package lesson4.animals;

public class Dog extends Animal {
    private String name;

    public Dog(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String greets() {
        return "Gaf";
    }

    public String greets(Dog another) {
        return "GafGaf";
    }

//    @Override
//    public void greets() {
//        System.out.println("Gaf");
//    }
//
//    @Override
//    public void greets(Dog dog) {
//        System.out.println("GafGaf");
//    }
//
//    @Override
//    public void greets(BigDog dog) {
//        System.out.println("GafGaf");
//    }
}
