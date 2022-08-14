package lesson4.reference;

import java.util.ArrayList;
import java.util.List;

public class AppTester {
    public static void main(String[] args) {
        // boolean int float long short bite ... - примитивные типы, их значения хранятся с stack памяти
        boolean a;  // по умолчанию значение = false
        long b;  // по умолчанию значение = 0


        // референсные типы = ссылочные типы = reference types
        // Class, [], @Test, interface, enum String - ссылочные типы

        String c = null;
        Person p = new Person("Max");
        System.out.println(c);
        System.out.println(p);

        // int double boolean
        // Integer Double Boolean
        int t = 50;
        // Integer a1 = new Integer(t);
        Integer a1 = t;
        Integer a2 = t;  // boxing - инициализация ссылочного типа по значению примитивного типа

        List<Integer> intList = new ArrayList<>();

        if (a2 < 200) {  // unboxing - сравнение ссылочного типа с примитивным
            System.out.println("It's less");
        }

        if (a1 == a2) {  // эквивалентность для ссылочных типов, сравнивание их по адресу в памяти
            // указывают ли эти ссылки на один и тот же объект
            System.out.println("==");
        } else System.out.println("!=");

        if (a1.equals(a2)) {
            System.out.println("equals");
        } else System.out.println("not equals");

    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
