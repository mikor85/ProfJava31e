package lesson22.jsonHomework;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int age;
    private String color;
    private String breed;

    public Cat(String name, int age, String color, String breed) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "{" + "name='" + name + ", age=" + age + ", color='" + color + ", breed='" + breed + '}';
    }
}