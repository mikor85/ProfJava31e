package lesson1.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTest {

    @Test
    public void testDate() {
        Date d1 = new Date(1990, 1, 9);
        assertEquals("1990-01-09", d1.toString());
    }
}
