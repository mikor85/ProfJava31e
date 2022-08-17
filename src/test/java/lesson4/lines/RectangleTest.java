package lesson4.lines;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void testRectangle() {

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(1, 1));
        points.add(new Point(0, 1));

        Rectangle r = new Rectangle(points);
        assertEquals(4, r.getLength(), 0.0001);
    }
}
