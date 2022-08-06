package lesson2.homework.author;

// Создайте класс Author  с полями firstName и lastName,
// добавьте конструктор, геттеры, сеттеры и toString.
// Создайте класс Book с полями title, author: Author и price.
// Напишите конструктор, геттеры, сеттеры и toString

public class App {
    public static void main(String[] args) {
        Author a1 = new Author("Ivan", "Ivanov");
        Author a2 = new Author("Petr", "Petrov");

        System.out.println(a1);
        System.out.println(a2);

        System.out.println("----------");
        Book b1 = new Book("Кладка печей", a1, 20);
        System.out.println(b1);

        System.out.println("----------");
        Book b2 = new Book("История древнего Египта", a2, 15);
        System.out.println(b2);
    }
}
