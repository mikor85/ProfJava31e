package lesson17;

public interface NoArgsReturnsDouble {
    double function();

    // default - метод, который может быть переопределен в подклассах
    default String hello() {
        return "Hello";
    }

    // в интерфейсе могут быть статические методы и поля
    static String anotherHello() {
        return "Another Hello";
    }
}
