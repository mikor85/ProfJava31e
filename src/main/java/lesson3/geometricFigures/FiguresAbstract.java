package lesson3.geometricFigures;

public abstract class FiguresAbstract {
    private String material;

    abstract double getArea();

    abstract double getPerimeter();

    public FiguresAbstract() {
        material = "Aluminium";

        // Carton
        // Plastic
    }

    public double calcPrice() {
        if (material.equals("Aluminium"))
            return 20 * getArea();
        else if (material.equals("Carton"))
            return 5 * getArea();
        else
            return 15 * getArea();
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
