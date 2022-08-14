package lesson4.lines;

import lesson4.animals.Cat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void testTriangle() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 1);

        List<Point> points = new ArrayList<>();
        points.add(p0);
        points.add(p1);
        points.add(p2);

        Triangle t1 = new Triangle(points);
        assertEquals(4.82843, t1.getLength(), 0.0001);
    }
}
