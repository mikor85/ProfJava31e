package lesson23;

import java.io.*;
import java.util.StringTokenizer;

public class EmployeeTester {
    public static void main(String[] args) throws FileNotFoundException {

//        Employee e = new Employee("Max Kotkov", 15_000, 27);
//        try (PrintWriter printWriter = new PrintWriter("employee.txt");) {
//            printWriter.println(
//                    e.getName() + "|" + e.getSalary() + "|" + e.getAge()
//            );
//        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("employee.txt"))) {
            String s = bufferedReader.readLine();
            StringTokenizer t = new StringTokenizer(s, "|");
            String name = t.nextToken();
            double salary = Double.parseDouble(t.nextToken());
            int age = Integer.parseInt(t.nextToken());
            Employee e = new Employee(name, salary, age);
            System.out.println(e);
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }
}
