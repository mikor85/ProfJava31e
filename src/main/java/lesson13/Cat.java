package lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cat implements Comparable<Cat> {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(
                Arrays.asList(
                        new Cat(Breed.BURMESE, 12, "Max"),
                        new Cat(Breed.BURMESE, 14, "Alex"),
                        new Cat(Breed.SIAMESE, 8, "Tikhon")
                )
        );
        // Отсортировать котов по возрасту

//        cats.sort(new Comparator<Cat>() {
//            @Override
//            public int compare(Cat c1, Cat c2) {
//                return c1.getAge() - c2.getAge();
//            }
//        });

        cats.sort((c1, c2) -> c1.getAge() - c2.getAge());
        System.out.println(cats);

        // отсортировать котов по убыванию имен
        cats.sort((c1, c2) -> c2.getName().compareTo(c1.getName()));
        System.out.println(cats);

        // отсортируйте котов по породе, по возрасту, по имени
        cats.sort(Comparator.comparing(Cat::getBreed)
                .thenComparing(Cat::getAge)
                .thenComparing(Cat::getAge)
        );
        System.out.println(cats);

    } // end of main

    @Override
    public String toString() {
        return "Cat{" +
                "b=" + breed +
                ", a=" + age +
                ", n='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat c) {
        return name.compareTo(c.getName());
    }

    public enum Breed {
        BURMESE, SIAMESE, SIBERIAN, SPHINX
    }

    private Breed breed;
    private int age;
    private String name;

    public Cat(Breed breed, int age, String name) {
        this.breed = breed;
        this.age = age;
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
