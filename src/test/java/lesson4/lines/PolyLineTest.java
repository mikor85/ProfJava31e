package lesson4.lines;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PolyLineTest {
    @Test
    public void testPolyLine() {

        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(1, 1));
        points.add(new Point(0, 1));

        PolyLine pl = new PolyLine(points);
        //pl.appendPoint(new Point(1, -1));
        //pl.appendPoint(new Point(0, 0));
        assertEquals(3, pl.getLength(), 0.0001);
    }
}
