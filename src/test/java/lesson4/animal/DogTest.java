package lesson4.animal;

import lesson4.animals.Dog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {
    @Test
    public void testDog()
    {
        Dog c = new Dog("Polkan");
        Dog d = new Dog("Barbos");
        assertEquals("Gaf", c.greets());
        assertEquals("GafGaf", c.greets(d));
    }
}

