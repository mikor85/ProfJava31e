package lesson22;

import java.io.*;

public class ObjectIO {
    public static void main(String[] args) {

        /*
        try (FileOutputStream fileOutputStream = new FileOutputStream("dog.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Dog barbos = new Dog("Barbos", 7);
            objectOutputStream.writeObject(barbos);
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
         */
        try (FileInputStream fileInputStream = new FileInputStream("dog.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            if(o instanceof Dog) {
                Dog dog = (Dog) o;
                System.out.println(dog.name);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

class Dog implements Serializable {
    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}