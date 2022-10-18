package lesson22;

import java.io.*;

public class DataInputTester {
    public static void main(String[] args) {
        //DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"));
        /*
        try (FileOutputStream fileOutputStream = new FileOutputStream("data.bin");
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
        ) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeDouble(33.44);
            dataOutputStream.writeInt(55);
            dataOutputStream.writeChars("hello");
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        */

        try (FileInputStream fileInputStream = new FileInputStream("data.bin");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {

            boolean first = dataInputStream.readBoolean();
            double salary = dataInputStream.readDouble();
            int age = dataInputStream.readInt();
            //String s = dataInputStream.readUTF();
            System.out.println("salary: " + salary + " age: " + age);
        } catch (IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
