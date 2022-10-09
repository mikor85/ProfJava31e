package lesson19;

import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.crypto.spec.PSource;
import javax.lang.model.element.NestingKind;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmpTester {
    public static void main(String[] args) {
        List<Emp> employees = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Shapovalov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Nikolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Petr Sveshnikov", 37, "programmer"),
                new Emp("Alex Con", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

        // найдите самого молодого
        employees.stream()
                .min(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);


        System.out.println("----------");
        // распечатайте только имена всех работников
        employees.stream().map(Emp::getName).forEach(System.out::println);


        System.out.println("----------");
        // распечатайте всех с возрастом больше 41 года
        employees.stream()
                .filter(emp -> emp.getAge() > 41)
                .forEach(System.out::println);


        System.out.println("----------");
        // распечатать всех работников отсортировав их по профессии и возрасту
        employees.stream()
                .sorted(Comparator.comparing(Emp::getPosition).thenComparing(Emp::getAge))
                .forEach(System.out::println);


        System.out.println("----------");
        // заджойнить имена всех работников старше 36 лет через ", "
        String employeesOlder36 =
                employees.stream()
                        .filter(emp -> emp.getAge() > 36)
                        .map(Emp::getName)
                        .collect(Collectors.joining(", "));
        System.out.println(employeesOlder36);

        employees.stream()
                .filter(emp -> emp.getAge() > 36)
                .map(Emp::getName)
                .reduce((prev, curr) -> prev + ", " + curr)
                .ifPresent(System.out::println);


        System.out.println("----------");
        // посчитайте сумму возрастов работников
        int sum =
                employees.stream()
                        .mapToInt(Emp::getAge)
                        .sum();
        System.out.println("Суммарный возраст работников = " + sum);


        System.out.println("----------");
        // посчитайте количество программистов
        long programmerCounter =
                employees.stream()
                        .filter(emp -> Objects.equals(emp.getPosition(), "programmer"))
                        .count();
        System.out.println("Кол-во программистов: " + programmerCounter);


        System.out.println("----------");
        // посчитайте средний возраст
        System.out.print("Средний возраст = ");
        employees.stream()
                .mapToInt(Emp::getAge)
                .average()
                .ifPresent(System.out::println);


        System.out.println("----------");
        // разделите на две группы - старше 40 лет и младше
        // найдите профессию самого "старого" из "молодых"

        Map<Boolean, List<Emp>> oldYoung = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 40));

        oldYoung.get(false)
                .stream()
                .max(Comparator.comparing(Emp::getAge))
                .ifPresent(System.out::println);


        System.out.println("----------");
        // сгруппируйте по профессии
        // Collectors.groupingBy(new Function<Object, Object>() {})
        Map<String, List<Emp>> byProfession = employees.stream()
                .collect(Collectors.groupingBy(Emp::getPosition));

        System.out.println(byProfession);


        System.out.println("----------");
        // распечатать профессии и количество работников в ней
        Map<String, Long> countProfEmp =
                employees.stream()
                        .collect(Collectors.groupingBy(Emp::getPosition, Collectors.counting()));

        System.out.println(countProfEmp);


        System.out.println("----------");
        // вернуть средний возраст мужчин и женщин - у женщин фамилия оканчивается на "a"
        System.out.print("Средний возраст мужчин = ");
        employees.stream()
                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) != 'a')
                .mapToInt(Emp::getAge)
                .average()
                .ifPresent(System.out::println);

        System.out.print("Средний возраст женщин = ");
        employees.stream()
                .filter(emp -> emp.getName().charAt(emp.getName().length() - 1) == 'a')/*.toList()*/
                .mapToInt(Emp::getAge)
                .average()
                .ifPresent(System.out::println);


        System.out.println("----------");
        // распечатать работников с самым часто встречающимся возрастом

        //List<Emp> empList =
        employees.stream()
                .collect(Collectors.groupingBy(Emp::getAge, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);


        //Stream.of(1, 3, 4, 3, 4, 3, 2, 3, 3, 3, 3, 3)
        //      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        //      .entrySet()
        //      .stream()
        //      .max(Map.Entry.comparingByValue())
        //      .ifPresent(System.out::println);

    }
}