package lesson22.jsonHomework;

import com.google.gson.Gson;

import java.io.*;

public class JsonClassTester {
    public static void main(String[] args) {
        // Напишите функции которые сериализуют и десериализуют экземпляр
        // какого-нибудь класса в json-представление в текстовом файле и обратно
        // Можно воспользоваться библиотекой Gson.
        Cat cat1 = new Cat("Murzik", 2, "Black", "Siberian");
        Cat cat2 = new Cat("Listik", 5, "White", "Persian");
        Cat cat3 = new Cat("Gav", 1, "Red", "Siamese");
        String fileTxt = "jsonObject.txt";
        //jsonTxtFileWriter(cat1, fileTxt);
        System.out.println(jsonTxtFileReaderMy(fileTxt));
        Cat c = jsonTxtFileReader(fileTxt, Cat.class);
        System.out.println(c);
    }

    public static void jsonTxtFileWriter(Object o, String file) {
        Gson gson = new Gson();
        String s = gson.toJson(o);

        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(s);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static <T> T jsonTxtFileReader(String file, Class<T> tClass) {
        Gson gson = new Gson();
        StringBuilder json = new StringBuilder();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach(
                    json::append
            );
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return gson.fromJson(json.toString(), tClass);
    }

    // My
    public static Object jsonTxtFileReaderMy(String file) {
        Gson gson = new Gson();
        StringBuilder json = new StringBuilder();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach(
                    json::append
            );
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return gson.fromJson(json.toString(), Object.class);
    }
}