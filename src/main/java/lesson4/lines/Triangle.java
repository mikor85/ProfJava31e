package lesson4.lines;

import java.util.List;

public class Triangle implements Figure {
    private List<Point> points;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle points: " + '\n' +
                "point 1: " + points.get(0) + "; " + '\n' +
                "point 2: " + points.get(1) + "; " + '\n' +
                "point 3: " + points.get(2) + ".";
    }

    // method overloading - перегрузка методов
//    private double getLength(Point p0, Point p1) {
//        return Math.sqrt(
//                Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2)
//        );
//    }

    // overriding - переопределение метода суперкласса
    @Override
    public double getLength() {
        Point p0 = points.get(0);
        Point p1 = points.get(1);
        Point p2 = points.get(2);
        //return getLength(p0, p1) + getLength(p1, p2) + getLength(p2, p0);
        return p0.getLength(p1) + p1.getLength(p2) + p2.getLength(p0);
    }
}
