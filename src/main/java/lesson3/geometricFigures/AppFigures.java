package lesson3.geometricFigures;

import java.util.ArrayList;
import java.util.List;

public class AppFigures {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(2, 3);

        List<FiguresAbstract> figures = new ArrayList<>();
        figures.add(new Rectangle(2, 3));
        figures.add(new Ellipse(2, 3));

        double perimeter = 0;
        double area = 0;
        double price = 0;
        for (int i = 0; i < figures.size(); i++) {
            perimeter += figures.get(i).getPerimeter();
            area += figures.get(i).getArea();
            price += figures.get(i).calcPrice();
        }
        System.out.println("area: " + area);
        System.out.println("perimeter: " + perimeter);
    }
}
