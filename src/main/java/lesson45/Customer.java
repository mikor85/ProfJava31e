package lesson45;

public class Customer {
    private int id;       // cnum    - уникальный номер заказчика
    private String name;  // cname   - имя
    private String city;  // city    - город
    private int rating;   // raiting - рейтинг
    private Sales sales;
    private int salesId;  // snum    - номер менеджера

    public Customer() {
    }

    public Customer(int id, String name, String city, int rating, int salesId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rating = rating;
        this.salesId = salesId;
    }

    public Customer(int id, String name, String city, int rating, Sales sales) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.rating = rating;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", sales=" + sales +
                '}';
    }
}