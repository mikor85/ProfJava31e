package lesson2.inheritance;

public class Staff extends Person {
    private String faculty;
    private double salary;

    public Staff(String name, String address, String faculty, double salary) {
        super(name, address);
        this.faculty = faculty;
        this.salary = salary;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Stuff[name=%s, address=%s, faculty=%s, salary=%f]"
                , name, address, getFaculty(), getSalary());
    }
}
