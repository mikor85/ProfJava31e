package lesson4.reference;

import org.junit.Test;

public class referenceTypeTest {
    @Test
    public void example(){
        Person p = new Person("Max");
        System.out.println("Before modify: " + p.getName());
        modify(p);
        System.out.println("After modify: " + p.getName());
    }

    public static void modify(Person d){
        d.setName("Alex");
        System.out.println("In modify: " + d.getName());
    }
}
