package lesson1.salary;

public class JapaneseSalary {
    public static void main(String[] args) {
        System.out.println(calculateSalary(50_000, 20_000, 30));

        SalaryCalculator calculator = new SalaryCalculator(50_000, 20_000);
        System.out.println(
                calculator.calculate(30)
        );

    }

    public static double calculateSalary(double baseSalary, double earlyIncrease, int year) {
        return baseSalary + earlyIncrease * year;
    }
}
