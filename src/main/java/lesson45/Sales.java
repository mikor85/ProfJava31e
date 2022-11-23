package lesson45;

public class Sales {
    private int id;
    private String name;
    private String city;
    private int commission;

    public Sales() {
    }

    public Sales(int id, String name, String city, int commission) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.commission = commission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        int fieldLength = 10;
        StringBuilder nameSb = new StringBuilder();
        StringBuilder citySb = new StringBuilder();
        nameSb.append(" ".repeat(Math.max(0, fieldLength - name.length()))).append(name);
        citySb.append(" ".repeat(Math.max(0, fieldLength - city.length()))).append(city);
        return id + "  |  " + nameSb + "  |  " + citySb + "  |  " + commission;
    }
}