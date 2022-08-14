package lesson4.reference;

import org.junit.Test;

public class ChangeReferenceTest {
    @Test
    public void example() {
        Person p = new Person("Max");
        System.out.println("Before modify: " + p.getName());
        modify(p);
        System.out.println("After modify: " + p.getName());
    }

    public static void modify(Person p) {
        p = new Person("Alex");
        p.setName("Alex");
        System.out.println("In modify: " + p.getName());
    }

}
