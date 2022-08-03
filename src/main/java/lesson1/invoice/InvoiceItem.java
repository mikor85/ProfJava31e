package lesson1.invoice;

public class InvoiceItem {
    private String partNumber;
    private String description;
    private int count;
    private double unitPrice;


    // Constructor
    public InvoiceItem(String partNumber, String description, int count, double unitPrice) {
        this.partNumber = partNumber;
        this.description = description;
        this.count = count;
        this.unitPrice = unitPrice;
    }

    // Getters
    public String getPartNumber() {
        return partNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {

        return String.format("%s '%-15.15s' count =%3d *%5.2f =%5.2f ", partNumber, description, count, unitPrice, count * unitPrice);

        /*
        %s - строковой формат
        %d - формат для целых чисел
        %f - плавающая точка
        - (минус) - левое выравнивание
        15.15 - максимальная длина поля и выравнивание
        */


        /*
        return "partNumber:'" + partNumber + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", unitPrice=" + unitPrice;

         */
    }
}
