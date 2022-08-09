package lesson3.geometricFigures;

import lesson3.geometricFigures.FiguresAbstract;

// public class Rectangle implements FiguresInterface {
public class Rectangle extends FiguresAbstract {
    double width, height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

}
