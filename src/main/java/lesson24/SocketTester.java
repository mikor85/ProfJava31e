package lesson24;

import java.io.*;
import java.net.Socket;

public class SocketTester {
    public static void main(String[] args) {
        // "www.whitehouse.gov" -> 192.0.66.168
        // colormind.io/list/
        // http -> port 80/tcp
        // https -> port 443/tcp
        // smtp -> port 25/tcp
        // ftp -> 21/tcp
        // dns 53/udp

        String serverName = "colormind.io";
        int port = 80;
        String webService = "/list/";
        try (
                Socket socket = new Socket(serverName, port); // tcp
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {
            outputStreamWriter.write("GET http://" + serverName + webService + " HTTP/1.0\n\n");
            outputStreamWriter.flush();
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }


    }


}