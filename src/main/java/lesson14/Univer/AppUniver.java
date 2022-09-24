package lesson14.Univer;

// Есть класс Student name, age, speciality
// и класс Professor имя, зарплата и список его студентов.
// Напишите геттеры, сеттеры и конструкторы, а также Comparator для преподавателя по числу его студентов.

import java.util.*;

public class AppUniver {
    public static void main(String[] args) {

        Student s1 = new Student("Max", 19, "Logistic");
        Student s2 = new Student("Alex", 20, "Economy");
        Student s3 = new Student("Bob", 21, "Technical");
        Student s4 = new Student("Kazimir", 22, "Robotic");
        Student s5 = new Student("John", 23, "History");
        Student s6 = new Student("Sergey", 24, "Philology");
        Student s7 = new Student("Rudolf", 25, "Sport");
        Student s8 = new Student("Leonid", 26, "Journalism");

        List<Student> studentListFirst = new ArrayList<>(Arrays.asList(
                s1, s2, s3, s4, s5, s6));
        System.out.println(studentListFirst);
        System.out.println("----------");
        List<Student> studentListSecond = new ArrayList<>(Arrays.asList(
                s2, s3, s4, s5, s6, s7, s8));
        System.out.println(studentListSecond);
        System.out.println("----------");

        Professor p1 = new Professor("Aleksandr Ivanovich", 18_000);
        p1.addStudent(s1);
        p1.addStudent(s3);
        System.out.println(p1);
        Professor p2 = new Professor("Aleksey Petrovich", 20_000);
        p2.addStudent(s2);
        System.out.println(p2.compareTo(p1));

        List<Professor> professors = new ArrayList<>();
        professors.add(p1);
        professors.add(p2);
        System.out.println(professors);
        Collections.sort(professors, (o1, o2) -> Integer.compare(o1.getStudentList().size(), o2.getStudentList().size()));
        System.out.println(professors);
    }
}