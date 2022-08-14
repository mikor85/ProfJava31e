package lesson4.lines;

import java.util.ArrayList;
import java.util.List;

public class AppFiguresTester {
    public static void main(String[] args) {

        Point p0 = new Point(1, 1);
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(2, 0);

        List<Point> points = new ArrayList<>();
        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);

        Triangle t1 = new Triangle(points);
        System.out.println("Triangle length: " + t1.getLength());
        System.out.println("----------");
        System.out.println(t1);
        System.out.println("----------");

        Rectangle r1 = new Rectangle(points);
        System.out.println("Rectangle length: " + r1.getLength());
        System.out.println("----------");
        System.out.println(r1);
        System.out.println("----------");

        PolyLine pl1 = new PolyLine(points);
        pl1.appendPoint(new Point(1, -1));
        pl1.appendPoint(new Point(0, 0));
        System.out.println("PolyLine length: " + pl1.getLength());
        System.out.println("----------");
        System.out.println(pl1);
        System.out.println("----------");
    }
}
