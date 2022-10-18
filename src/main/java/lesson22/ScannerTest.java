package lesson22;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = 0;
        if (keyBoard.hasNextInt()) {
            age = keyBoard.nextInt();
        }
        //System.out.println();
        System.out.print("Enter your salary: ");
        double salary = 0;
        if (keyBoard.hasNextDouble()) {
            salary = keyBoard.nextDouble();
        }
        //System.out.println();
        System.out.println("Your age is " + age + " and your salary is " + salary);

        System.out.print("Enter your name: ");
        String name = "";
        keyBoard.nextLine();
        if (keyBoard.hasNext()){
            name = keyBoard.nextLine();
        }
        System.out.println("Your name is " + name);
    }
}
