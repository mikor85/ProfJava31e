package lesson1.salary;

public class SalaryCalculator {
    /*
    -baseSalary: double = 50_000
    -yearlyIncrease = 20_000
    ------------------------------------------------------------
    +SalaryCalculator(baseSalary double, yearlyIncrease: double)
    +calculate(years: int): double
     */

    private double baseSalary = 50_000;
    private double yearlyIncrease = 20_000;

    // Constructors
    public SalaryCalculator(double baseSalary, double yearlyIncrease) {
        this.baseSalary = baseSalary;
        this.yearlyIncrease = yearlyIncrease;
    }

    // Methods
    public double calculate(int year) {
        return baseSalary + yearlyIncrease * year;
    }

    // Getters and Setters
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getYearlyIncrease() {
        return yearlyIncrease;
    }

    public void setYearlyIncrease(double yearlyIncrease) {
        this.yearlyIncrease = yearlyIncrease;
    }
}