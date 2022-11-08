package lesson29;

public class Calculator {
    public Number multiply(Number f, Number s) {
        return f.doubleValue() * s.doubleValue();
    }

    public Number divide(Number f, Number s) {
        if (s.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return f.doubleValue() / s.doubleValue();
    }
}