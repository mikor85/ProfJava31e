package lesson1.salary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JapaneseSalaryTest {

    @Test
    public void testSalary() {
        assertEquals(650_000,
                JapaneseSalary.calculateSalary(50_000, 20_000, 30),
                0.001);
    }

    // напишите новую функцию, которая проверит правильность вычисления зарплаты в классе
    // SalaryCalculator

    @Test
    public void testSalaryCalculator() {
        SalaryCalculator calculator = new SalaryCalculator(50_000, 20_000);
        assertEquals(650_000,
                calculator.calculate(30),
                0.001);
    }
}
