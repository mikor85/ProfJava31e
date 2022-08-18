package lesson6.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Max Kotkov", new Address("Main street", "12")));
        people.add(new Person("Semen Petrov", new Address("Fleet street", "1")));
        people.add(new Person("Maria Ivanova", new Address("Light street", "44")));

        //System.out.println(getAddresses(people));

        for (Address a : getAddresses(people)) {
            System.out.println(a);
        }
        // создание - new "реализация"
        // доступ по индексу get(i)
        // добавление add(Person) add(i, Person)
        // изменение set(i, Person)
        // удаление remove(i) remove(Person)
        // размер size()

        System.out.println("----------");
        List<String> s = Arrays.asList("Max", "Smith", "Tandy", "Roger", "Michael", "Alexandra", "Lola");
        System.out.println(stringFilter(s, 4));
    }  // конец main

    // напишите функцию, которая принимает на вход список строк и возвращает список строк длинной более заданной длины
    // пример - если передать список строк и 4, вернутся строки длиной более 4
    public static List<String> stringFilter(List<String> names, int filterFactor) {
        List<String> res = new ArrayList<>();
        for (String s : names) {
            if (s.length() > filterFactor) {
                res.add(s);
            }
        }
        return res;
    }

    // напишите функцию, которая получает на вход список персон и возвращает список адресов
    public static List<Address> getAddresses(List<Person> persons) {
        List<Address> addressList = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            addressList.add(persons.get(i).address);
        }
        return addressList;
    }
}
