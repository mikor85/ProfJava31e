package lesson14.Univer;

import java.util.List;

public class Professor implements Comparable<Professor> {
    private String name;
    private int salary;
    private List<Student> studentList;

    public Professor(String name, int salary, List<Student> studentList) {
        this.name = name;
        this.salary = salary;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Professor{" + name + ", salary=" + salary +
                ", studentList:" + '\n' +
                studentList + '}';
    }

    @Override
    public int compareTo(Professor o) {
        return Integer.compare(studentList.size(), o.getStudentList().size());
    }
}
