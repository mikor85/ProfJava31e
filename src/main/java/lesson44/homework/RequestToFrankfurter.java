package lesson44.homework;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RequestToFrankfurter {
    public static void main(String[] args) {
        double amount = 100;
        String convertFrom = "USD";
        String convertTo = "EUR";

        addRateInDB(amount, convertFrom, convertTo);
        //removeRowRateFromDB(amount);
    }

    public static void removeRowRateFromDB(double amount) {
        String url = "jdbc:sqlite:frankfurter.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            statement.execute("delete from rates where amount = " + amount + ";");
        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }

    public static void addRateInDB(double amount, String convertFrom, String convertTo) {
        String url = "jdbc:sqlite:frankfurter.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            statement.execute("create table if not exists rates (amount double not null, " +
                    "base text not null, " +
                    "date text not null, " +
                    "convertCurrency text not null, " +
                    "convertValue double not null);");
            Rate r = getRate(amount, convertFrom, convertTo);
            if (r != null) {
                statement.execute("insert into rates values (" +
                        r.amount + ", '" +
                        r.base + "', '" +
                        r.date + "', '" +
                        convertTo + "', " +
                        r.rates.get(convertTo) + ");");
            }

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }

    public static Rate getRate(double amount, String from, String to) {
        Gson gson = new Gson();
        try {
            URL url = new URL("https://api.frankfurter.app/latest?amount=" + amount + "&from=" + from + "&to=" + to);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Reader reader = new InputStreamReader(connection.getInputStream());
            return gson.fromJson(reader, Rate.class);

        } catch (IOException e) {
            System.err.println("Exception in getRate " + e.getMessage());
        }
        return null;
    }

    static class Rate {
        public double amount;
        public String base;
        public String date;

        public Map<String, Double> rates = new HashMap<>();
        // {"amount":10.0,"base":"GBP","date":"2022-11-17","rates":{"USD":11.7965}}

        @Override
        public String toString() {
            return "Rate{" +
                    "amount=" + amount +
                    ", base='" + base + '\'' +
                    ", date='" + date + '\'' +
                    ", rates=" + rates +
                    '}';
        }
    }
}