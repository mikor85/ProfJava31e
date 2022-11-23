package lesson45;

public class Order {
    private int id;             // onum  - уникальный номер заказа
    private int sum;            // amt   - сумма заказа
    private Customer customer;
    private String date;        // odate - дата заказа
    private Sales sales;
    private int customerId;     // cnum  - номер заказчика
    private int salesId;        // snum  - номер продавца

    public Order() {

    }

    public Order(int id, int sum, int customerId, String date, int salesId) {
        this.id = id;
        this.sum = sum;
        this.customerId = customerId;
        this.date = date;
        this.salesId = salesId;
    }

    public Order(int id, int sum, Customer customer, String date, Sales sales) {
        this.id = id;
        this.sum = sum;
        this.customer = customer;
        this.date = date;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sum=" + sum +
                ", customer=" + customerId +
                ", date='" + date +
                ", sales=" + salesId +
                '}';
    }
}