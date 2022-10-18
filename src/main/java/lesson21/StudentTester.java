package lesson21;

import lesson19.Emp;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentTester {
    public static void main(String[] args) {
        // Java Streams: Collectors and custom Collectors
        // Collector - сгруппировать, разделить, обсчитать или сохранить в коллекцию элементы потока
        // collect() - терминальная операция потока

        // Collectors - типы
        //    Partition - передаем предикат и поток делится на две группы - удовлетворяющие предикату и нет
        //    Grouping - передаем две функцию для создания ключей и значений - на выходе Map
        //    Reducing - вычисление какого-то значения по всем элементам потока
        //    Collection - создание коллекции на базе потока

        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobisheva", 19),
                new Student("Max", "Palov", 24)
        );

        System.out.println(students.stream()
                .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .collect(Collectors.toList()));  // ArrayList

        Collection<String> c =
                students.stream()
                        .map(Student::getLastName)
                        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(c);

        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toUnmodifiableList()); // RO List

        // Set
        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toSet());  // Set

        students.stream()// .filter(s -> s.getLastName().toLowerCase().contains("s"))
                .map(Student::getLastName)
                .collect(Collectors.toCollection(TreeSet::new)); // TreeSet

        // Map
        students.stream()
                //.map(Student::getLastName)
                .collect(Collectors.groupingBy(Student::getAge)); // Map<String, List<Student>>

        // формирует ключи
        Map<String, Student> stringStudentMap =
                students.stream()
                        .collect(Collectors.toMap(
                                s -> s.getLastName() + " " + s.getFirstName(),
                                Function.identity() // s -> s
                        ));
        System.out.println(stringStudentMap);

        // Collectors.toUnmodifiableMap()  // RO Map

        // String
        System.out.println(
                students.stream()
                        .map(Student::getLastName)
                        .collect(Collectors.joining(", ", "<", ">"))
        );

        // Числовая статистика
        IntSummaryStatistics intSummaryStatistics =
                students.stream()
                        .collect(Collectors.summarizingInt(Student::getAge));

        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());


        students.stream()
                // filter ?
                .collect(Collectors.counting());  // количество элементов в потоке

        students.stream()
                // filter ?
                .collect(Collectors.summarizingInt(Student::getAge));  // сумму возрастов

        Optional<Student> maxStudent =
                students.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparing(Student::getLastName)
                        ));  // max()

        // Collectors.minBy

        // Partition
        Map<Boolean, List<Student>> studentPartition =
                students.stream()
                        .collect(Collectors.partitioningBy(s -> s.getLastName().endsWith("a")));
        System.out.println(studentPartition);

        // посчитайте сумму возрастов мужчин и женщин
        studentPartition.entrySet()
                .stream()
                .forEach(
                        entry -> System.out.println(
                                entry.getValue().stream().map(Student::getAge).reduce(0, Integer::sum).doubleValue()
                        ));

        studentPartition.values().stream()
                .map(
                        studentList -> studentList.stream()
                                .collect(Collectors.summarizingInt(Student::getAge))
                                .getSum())
                .forEach(System.out::println);

        studentPartition.values().stream().map(
                list -> list.stream().map(Student::getAge).reduce(0, Integer::sum)
        ).forEach(System.out::println);


        // groupingBy
        Map<Integer, List<Student>> studentByAge =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge));
        System.out.println(studentByAge);

        Map<Integer, Set<Student>> studentByAgeSet =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge, Collectors.toSet()));
        System.out.println(studentByAgeSet);


        // studentByAge
        // распечатайте возраст ключ и количество людей в каждом возрасте
        studentByAge.forEach(
                (age, students1) -> System.out.println(age + ":" + students1.size())
        );

        Map<Integer, Long> studentByAgeQuantity =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        System.out.println(studentByAgeQuantity);


        // Custom Collector
        // interface Collector <T, A, R>
        // T - тип того, что коллектор обрабатывает, например, Student;
        // A - тип аккумулятора - коллекция, куда студенты записываются либо для возвращения,
        // либо для дальнейшей обработки;
        // R - тип возвращаемого значения - например, коллекция List<Student> либо какая-то статистика -
        // Double если нужно посчитать средний возраст.


        // supplier() - должен возвратить Supplier, который создаст тип возвращаемого значения (коллекцию),
        // куда accumulator() будет добавлять значения;

        // accumulator() - в него передается коллекция (Map) и один элемент из потока (Student),
        // accumulator определяет стратегию как именно будет добавляться объект в map;

        // combiner() - при параллельном выполнении потока отвечает за слияние промежуточных результатов;

        // finisher() - преобразует коллекцию-аккумулятор в тип возвращаемого значения;

        // characteristics() -

        Map<Integer, List<Student>> customStudentsByAge =
                students.stream()//.parallel()
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {

                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                return new Supplier<Map<Integer, List<Student>>>() {
                                    @Override
                                    public Map<Integer, List<Student>> get() {
                                        return new HashMap<>(); // создаем Map в который будут накапливаться Students
                                    }
                                };
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return new BiConsumer<Map<Integer, List<Student>>, Student>() {
                                    @Override
                                    public void accept(Map<Integer, List<Student>> map, Student student) {
                                        // получить из приходящего Student ключ
                                        int age = student.getAge();
                                        // посмотреть, есть ли в map список студентов с таким возрастом
                                        // если его нет, то создать этот список
                                        List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                        // добавить в список студента
                                        studs.add(student);
                                        // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                        map.put(age, studs);
                                    }
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return new BinaryOperator<Map<Integer, List<Student>>>() {
                                    @Override
                                    public Map<Integer, List<Student>> apply(
                                            Map<Integer, List<Student>> f,
                                            Map<Integer, List<Student>> s) {
                                        f.putAll(s);
                                        return f;
                                    }
                                };
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>> finisher() {
                                return new Function<Map<Integer, List<Student>>, Map<Integer, List<Student>>>() {
                                    @Override
                                    public Map<Integer, List<Student>> apply(Map<Integer, List<Student>> map) {
                                        return map;
                                    }
                                };
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                            }
                        });

        System.out.println(customStudentsByAge);

        // Коллектор, который вернет максимальное кол-во людей в одном возрасте
        int maxNumberOfStudentsInAge =
                students.stream()     // T - входное      A - аккумулятор            R - выходное
                        .collect(new Collector<Student, Map<Integer, List<Student>>, Integer>() {
                            @Override
                            public Supplier<Map<Integer, List<Student>>> supplier() {
                                return HashMap::new;
                            }

                            @Override
                            public BiConsumer<Map<Integer, List<Student>>, Student> accumulator() {
                                return new BiConsumer<Map<Integer, List<Student>>, Student>() {
                                    @Override
                                    public void accept(Map<Integer, List<Student>> map, Student student) {
                                        // получить из приходящего Student ключ
                                        int age = student.getAge();
                                        // посмотреть, есть ли в map список студентов с таким возрастом
                                        // если его нет, то создать этот список
                                        List<Student> studs = map.containsKey(age) ? map.get(age) : new ArrayList<>();
                                        // добавить в список студента
                                        studs.add(student);
                                        // по ключу-возрасту сохранить в map список со студентами нужного возраста
                                        map.put(age, studs);
                                    }
                                };
                            }

                            @Override
                            public BinaryOperator<Map<Integer, List<Student>>> combiner() {
                                return (f, s) -> {
                                    f.putAll(s);
                                    return f;
                                };
                            }

                            @Override
                            public Function<Map<Integer, List<Student>>, Integer> finisher() {
                                return new Function<Map<Integer, List<Student>>, Integer>() {
                                    @Override
                                    public Integer apply(Map<Integer, List<Student>> map) {
                                        return map.values().stream()
                                                .map(Collection::size)
                                                .max(Comparator.naturalOrder())
                                                .orElse(0);
                                    }
                                };
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED);
                            }
                        });

        System.out.println(maxNumberOfStudentsInAge);


    }
}