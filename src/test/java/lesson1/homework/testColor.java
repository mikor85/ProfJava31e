package lesson1.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testColor {
    @Test
    public void testMyColor() {
        Color c = new Color(0, 255, 255);
        assertEquals(180, c.getH(), 0.01);
        assertEquals(1, c.getS(), 0.01);
        assertEquals(0.5, c.getL(), 0.01);
    }
}
