package lesson23;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpTester {
    public static void main(String[] args) throws IOException {
        // https://api.frankfurter.app/
        URL url = new URL("https://api.frankfurter.app/latest?amount=10&from=GBP&to=EUR");
        // URLConnection connection = url.openConnection();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        bufferedReader.lines().forEach(
                builder::append
        );
        System.out.println(builder.toString());

        Gson gson = new Gson();
        Rate rate = gson.fromJson(builder.toString(), Rate.class);
        System.out.println(rate.base + " " + rate.amount);

        System.out.println(gson.toJson(rate));
    }
}
