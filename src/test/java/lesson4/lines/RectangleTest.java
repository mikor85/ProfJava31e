package lesson4.lines;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void testTriangle() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(2, 0);

        List<Point> points = new ArrayList<>();
        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        Rectangle r1 = new Rectangle(points);
        assertEquals(5.6569, r1.getLength(), 0.0001);
    }
}
