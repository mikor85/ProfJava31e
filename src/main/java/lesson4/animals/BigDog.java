package lesson4.animals;

public class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public String greets() {
        return "GAF";
    }

    @Override
    public String greets(Dog another) {
        return "GAFGAF";
    }

    public String greets(BigDog another) {
        return "GAFGAFGAF";
    }
}



//    @Override
//    public void greets() {
//        System.out.println("GAF");
//    }
//
//    @Override
//    public void greets(Dog dog) {
//        System.out.println("GAFGAF");
//    }
//
//    @Override
//    public void greets(BigDog dog) {
//        System.out.println("GAFGAFGAF");
//    }
