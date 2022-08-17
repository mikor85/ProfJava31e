package lesson5.json;


// https://api.country.is/9.9.9.9
// {"country":"US","ip":"9.9.9.9"}
public class GeoCode {
    private String country;
    private String ip;

    public GeoCode(String country, String ip) {
        this.country = country;
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
