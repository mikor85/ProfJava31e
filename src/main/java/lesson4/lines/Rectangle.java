package lesson4.lines;

import java.util.List;

public class Rectangle implements Figure {
    private List<Point> points;

    public Rectangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Rectangle points: " + '\n' +
                "point 1: " + points.get(0) + "; " + '\n' +
                "point 2: " + points.get(1) + "; " + '\n' +
                "point 3: " + points.get(2) + "; " + '\n' +
                "point 4: " + points.get(3) + ".";
    }

    // метод перенесен в класс Point
//    private double getLength(Point p0, Point p1) {
//        return Math.sqrt(
//                Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2)
//        );
//    }

    @Override
    public double getLength() {
        double l = 0;
        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1){
                l += points.get(i).getLength(points.get(i+1));
            } else l += points.get(i).getLength(points.get(0));
        }
        return l;
    }
}
