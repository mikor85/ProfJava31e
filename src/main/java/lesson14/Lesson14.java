package lesson14;

import com.sun.source.tree.Tree;
import lesson13.employee_homework.Employee;

import java.sql.SQLOutput;
import java.util.*;

public class Lesson14 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Martha", 24, 22_000);
        Employee e2 = new Employee(10, "John", 34, 12_000);
        Employee e3 = new Employee(12, "Alex", 27, 32_000);
        Employee e4 = new Employee(22, "Bertha", 21, 29_000);
        Employee e5 = new Employee(32, "Sam", 22, 12_000);

        List<Employee> emps = new ArrayList<>();
        emps.addAll(Arrays.asList(e1,e2,e3,e4,e5));

        System.out.println(Collections.max(emps, new Employee.AgeComparator()));

        Collections.sort(emps, new Employee.NameComparator());
        System.out.println(Collections.binarySearch(emps, e3, new Employee.NameComparator()));

        // Если класс имплементит Comparable, можно использовать Collection.sort(class_name) без компаратора.

        //TreeSet<Employee> employees = new TreeSet<>(Comparator.comparing(Employee::getAge));
        TreeSet<Employee> employees = new TreeSet<>();
        employees.addAll(Arrays.asList(e2, e1, e3, e5, e4));
        System.out.println(employees);

        TreeSet<String> group = new TreeSet<>(Arrays.asList(
                "Abba",
                "Boney M",
                "Led Zeppelin",
                "Aerosmith",
                "Pearl Jam",
                "ZZ Top"
        ));
        System.out.println(group);

        System.out.println(group.subSet("CC Catch", "Sandra"));

        System.out.println(group.tailSet("Fridays"));
    }
}
