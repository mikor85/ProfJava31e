package lesson1.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTest {

    @Test
    public void testDay() {
        Day d1 = new Day(1990, 1, 9);
        assertEquals("1990-01-09", d1.toString());
    }
}
