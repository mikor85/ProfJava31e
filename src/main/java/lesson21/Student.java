package lesson21;

public class Student {
    private String firstName;
    private String lastName;
    private int age;


    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{" +
                "f='" + firstName + '\'' +
                ", l='" + lastName + '\'' +
                ", a=" + age +
                '}';
    }
}
