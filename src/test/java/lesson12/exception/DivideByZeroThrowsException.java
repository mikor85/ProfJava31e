package lesson12.exception;

import lesson12.ExceptionTester;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DivideByZeroThrowsException {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divideBeZeroThrows() throws ExceptionTester.MyException {
        exception.expect(ExceptionTester.MyException.class);
        exception.expectMessage("Division by zero");
        ExceptionTester.divide(10, 0);
    }
}
