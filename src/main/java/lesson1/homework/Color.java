package lesson1.homework;

// * напишите класс Color с полями r, g, b - целые от 0 до 255.
// Добавьте вычисление HSL (Hue, Saturation, Luminance) по RGB.


public class Color {
    private int r, g, b;
    private double r1, g1, b1;

    private double cmax, cmin, delta;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;

        r1 = r / 255.0;
        g1 = g / 255.0;
        b1 = b / 255.0;

        cmax = Math.max(r1, Math.max(g1, b1));
        cmin = Math.min(r1, Math.min(g1, b1));
        delta = cmax - cmin;
    }

    public double getL() {
        return (cmax + cmin) / 2;
    }

    public double getS() {
        if (delta == 0) {
            return 0;
        }
        return delta / (1 - Math.abs(2 * getL() - 1));
    }

    public double getH() {
        if (delta == 0) {
            return 0;
        }
        if (cmax == r1) {
            return 60 * (((g1 - b1) / delta) % 6);
        }
        if (cmax == g1) {
            return 60 * (((b1 - r1) / delta) + 2);
        }
        if (cmax == b1) {
            return 60 * (((r1 - g1) / delta) + 4);
        }
        return 0;
    }

    // Getters and Setters
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


    public static void main(String[] args) {
        Color c = new Color(0, 128, 128);
        System.out.printf("h=%f, s=%f, l=%f", c.getH(), c.getS(), c.getL());
    }

}
