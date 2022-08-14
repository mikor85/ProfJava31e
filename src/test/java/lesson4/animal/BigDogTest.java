package lesson4.animal;

import lesson4.animals.BigDog;
import lesson4.animals.Dog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigDogTest {
    @Test
    public void testDog()
    {
        BigDog c = new BigDog("Polkan");
        Dog d = new Dog("Barbos");
        BigDog e = new BigDog("Max");
        assertEquals("GAF", c.greets());
        assertEquals("GAFGAF", c.greets(d));
        assertEquals("GAFGAFGAF", c.greets(e));
    }
}


