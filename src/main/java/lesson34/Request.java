package lesson34;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

// https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD
public class Request {

    public static Rate getRate(double amount, String from, String to) {
        Gson gson = new Gson();
        //Rate result = null;
        try {
            URL url = new URL("https://api.frankfurter.app/latest?amount=" + amount + "&from=" + from + "&to=" + to);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("getRate encoding " + connection.getContentEncoding());
            System.out.println("getRate content type " + connection.getContentType());
            Reader reader = new InputStreamReader(connection.getInputStream());
            return gson.fromJson(reader, Rate.class);

        } catch (IOException e) {
            System.err.println("Exception in getRate" + e.getMessage());
        }
        return /*result*/null;
    }
}