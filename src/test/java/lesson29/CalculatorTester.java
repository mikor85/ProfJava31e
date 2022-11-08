package lesson29;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTester {

    private static Calculator calc;


    // выполняется только один раз при загрузке класса
    // до всех тестовых методов
    @BeforeClass
    public static void before() {
        System.out.println("before");
        calc = new Calculator();
    }

    @Test
    public void testMultiplyTwoNumbers() {
        System.out.println("testMultiplyTwoNumbers");
        assertEquals("Should be 20.0", calc.multiply(4, 5), 20.0);
    }

    @Test
    public void testMultiplyByZero() {
        System.out.println("testMultiplyByZero");
        assertEquals("Should be 0.0", calc.multiply(0, 5), 0.0);
        assertEquals("Should be 0.0", calc.multiply(4, 0), 0.0);
    }

    @Before  // выполняется перед каждым тестируемым методом
    public void init() {
        System.out.println("init");
    }

    @After  // выполняется после каждого тестируемым методом
    public void tearDown() {
        System.out.println("tearDown");
    }

    // Тестируем выбрасывание исключения
    @Ignore("Currently don't working")
    @Test(expected = ArithmeticException.class)
    public void divideThrowsException() {
        System.out.println("divideThrowsException");
        calc.divide(12, 0);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsArithmeticException() {
        System.out.println("throwsArithmeticException");
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Division by zero");
        calc.divide(12, 0);
    }
}