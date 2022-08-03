package lesson1.geometry;

/*
- sw: Point = Point(1,1);
- ne: Point = Point(1,1);
---------------------------
+Rectangle(sw: Point, ne: Point);
+getArea(): int
 */

public class Rectangle {
    private Point sw;
    private Point ne;

    public Rectangle(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public int getArea(){
        return (ne.getX() - sw.getX()) * (ne.getY() - sw.getY());
    }
}
