package lesson24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTester {
    public static void main(String[] args) {
        // https://github.com/public-apis/public-apis

        // https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD
        String webService = "https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD";
        try {
            System.out.println(httpGetString(webService));
        } catch (MalformedURLException e) {
            System.err.println("Malformed: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static String httpGetString(String webService) throws IOException {
        URL url = new URL(webService);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder builder = new StringBuilder();
        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            bufferedReader.lines()
                    .forEach(builder::append);
        }
        return builder.toString();
    }
}
