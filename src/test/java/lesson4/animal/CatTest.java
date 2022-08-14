package lesson4.animal;

import lesson4.animals.Cat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatTest {
    @Test
    public void testCat() {
        Cat c = new Cat("Murzik");
        assertEquals("Meouw", c.greets());
    }
}

