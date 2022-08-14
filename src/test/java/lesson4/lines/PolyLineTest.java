package lesson4.lines;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PolyLineTest {
    @Test
    public void testPolyLine() {
        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(2, 0);

        List<Point> points = new ArrayList<>();
        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        PolyLine pl1 = new PolyLine(points);
        pl1.appendPoint(new Point(1, -1));
        pl1.appendPoint(new Point(0, 0));
        assertEquals(8.4853, pl1.getLength(), 0.0001);
    }
}
