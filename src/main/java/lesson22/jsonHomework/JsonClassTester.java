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
        //System.out.println(jsonTxtFileReader(fileTxt));
        jsonTxtFileReader(fileTxt);

//        Gson gson = new Gson();
//        StringBuilder test = new StringBuilder("{\"name\":\"Murzik\",\"age\":2,\"color\":\"Black\",\"breed\":\"Siberian\"}");
//        Object resObject = gson.fromJson(String.valueOf(test), Object.class);
//        System.out.println(resObject);
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

    public static void jsonTxtFileReader(String file) {
        Gson gson = new Gson();
        //StringBuilder json = new StringBuilder();
        String s = "";

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            s = bufferedReader.readLine();
            //json.append(bufferedReader.lines());
            //bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        Object resObject = gson.fromJson(String.valueOf(s), Object.class);
        System.out.println(resObject);
    }
}