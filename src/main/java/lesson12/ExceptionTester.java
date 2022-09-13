package lesson12;

import java.sql.SQLOutput;

public class ExceptionTester {
    public static void main(String[] args) /*throws MyException*/ {

        try {
            System.out.println(divide(14, 2));
            System.out.println(divide(10, 0));
            System.out.println(divide(3, 8));


        } catch (MyException e) {
            System.out.println("Caught Exception");
        }
        System.out.println("Exit");

        // Exception (исключение) - это специальная ситуация или ошибка,
        // которая возникла в процессе работы программы
        // Исключения выбрасываются JVM (Java Virtual Machine) либо кодом
        // Error выбрасывается JVM - в этом случае выполнение программы невозможно, перехватить Error нельзя
        // Например, OutOfMemoryError.

        // RunTimeException - ошибка программиста, перехватить можно, но нужно ли ?..
        // RunTimeException (unchecked exception) - нет необходимости их обрабатывать

        // Исключения производные от Exception нужно обрабатывать.
        // Exception (checked) - нужно ли перехватывать используя try-catch либо пробрасывать дальше,
        // где его должна обрабатывать вызвавшая наш код функция

    }

    public static int divide(int a, int b) throws MyException { // производный от Exception
        if (b == 0) {
            throw new MyException("Division by zero");
        }
        return a / b;
    }

    public static class MyException extends Exception {

        public MyException() {
            super();
        }

        public MyException(String message) {
            super(message);
        }
    }
}
