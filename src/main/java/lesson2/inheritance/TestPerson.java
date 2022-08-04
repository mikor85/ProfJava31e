package lesson2.inheritance;

import java.sql.SQLOutput;

public class TestPerson {
    public static void main(String[] args) {
        Person student = new Student("Max Kotkov", "Main Street, 22", "Music", 3);
        System.out.println(student);

        Person staff = new Staff("Timur", "Nikolaev", "Philosophy", 20_000);

        System.out.println(staff.getName());
        System.out.println(student.getAddress());

        staff = student;
        System.out.println(staff instanceof Student);

        Student s1 = (Student) staff;

        System.out.println(
                ((Student) staff).getProgram()
        );

        //Staff st1 = (Staff) staff;
        //System.out.println(st1.getFaculty());

        //System.out.println(staff instanceof Staff);

    }
}
