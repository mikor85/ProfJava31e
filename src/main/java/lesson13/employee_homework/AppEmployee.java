package lesson13.employee_homework;

// ДЗ проф ява:
// 1. В классе Employee есть поля int id, String name, int age, int salary. Допишите геттеры и конструктор.

// 2. Сделайте класс Employee Comparable по id.

// 3. Добавьте в класс возможности сортировать его экземпляры по зарплате; по возрасту;
// по имени - статические классы компараторы.

// 4. Отсортируйте список Employee по возрасту и по имени.

// 5. * Напишите функцию, которая принимает на вход список из целых и удаляет из него все числа,
// встречающиеся нечетное количество раз.

// 6. *** Напишите функцию, которая принимает на вход список Employee и список компараторов для сортировки Employee;
// сортирует переданный List<Employee> компараторами.
// public static void complexSort(List<Employee> emps, List<Comparator<Employee>> comparators).

import java.util.*;

public class AppEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Max", 23, 10_000);
        Employee employee2 = new Employee(2, "Max", 23, 10_000);
        System.out.println(employee1);
        System.out.println(employee1.compareTo(employee2));

        List<Employee> employeeList = new ArrayList<>(
                Arrays.asList(
                        new Employee(1, "Max", 23, 10_000),
                        new Employee(2, "Ilja", 27, 15_000),
                        new Employee(3, "Alex", 32, 20_000),
                        new Employee(4, "Bob", 35, 25_000),
                        new Employee(5, "Sergey", 29, 17_000)
                )
        );

        List<Comparator<Employee>> comparatorList = new ArrayList<>(
                Arrays.asList(
                        new Employee.NameComparator(),
                        new Employee.AgeComparator(),
                        new Employee.SalaryComparator()
                )
        );

        employeeList.sort(Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName));
        System.out.println(employeeList);

        Collections.sort(employeeList, new Employee.NameComparator());
        System.out.println(employeeList);
        Collections.sort(employeeList, new Employee.AgeComparator());
        System.out.println(employeeList);
        Collections.sort(employeeList, new Employee.SalaryComparator());
        System.out.println(employeeList);

        System.out.println("----------");
        complexSort(employeeList, comparatorList);
        System.out.println(employeeList);

        System.out.println("===== At the lesson =====");
        Employee e1 = new Employee(2, "Max", 33, 22_000);
        Employee e2 = new Employee(3, "John", 30, 25_000);
        Employee e3 = new Employee(3, "Magda", 33, 22_000);
        Comparator<Employee> c1 = new Employee.NameComparator();

        System.out.println(
                c1.compare(e1, e2)
        );
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        Collections.sort(employees, Comparator
                .comparing(Employee::getAge)
                .thenComparing(Employee::getName));
        System.out.println(employees);

        complexSort(employees, Arrays.asList(new Employee.NameComparator(), new Employee.AgeComparator()));
        System.out.println(employees);
    }

    public static void complexSort(List<Employee> employees, List<Comparator<Employee>> comparators) {
        Comparator<Employee> comparator = comparators.get(0);
        for (int i = 1; i < comparators.size(); i++) {
            comparator.thenComparing(comparators.get(i));
        }
        employees.sort(comparator);
    }
}
