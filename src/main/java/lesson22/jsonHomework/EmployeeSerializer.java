package lesson22.jsonHomework;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EmployeeSerializer {
    public static void main(String[] args) {
        String fileName = "kuptsov.json";
//        Employee employee = new Employee(22, "Sergej Kuptsov", 3_500, 24);
//        writeObjectToFile("fileName", employee);

        System.out.println(getEmployeeFromFile(fileName));

        Employee employee = getEmployeeFromFile(fileName, Employee.class);
        System.out.println(employee);

    }

    public static <T> T getEmployeeFromFile(String filename, Class<T> clazz) {
        Gson gson = new Gson();
        T result = null;
        try (
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            result = gson.fromJson(bufferedReader, clazz);
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
        return result;
    }

    public static Employee getEmployeeFromFile(String filename) {
        Gson gson = new Gson();
        Employee employee = null;
        try (
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            employee = gson.fromJson(bufferedReader, Employee.class);
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
        return employee;
    }

    public static void writeObjectToFile(String filename, Object object) {
        Gson gson = new Gson();
        String obj = gson.toJson(object);
        try (FileWriter fileWriter = new FileWriter(filename);    // #2 close()
             PrintWriter printWriter = new PrintWriter(fileWriter)) {  // #1 close()
            printWriter.println(obj);
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
    }
}
