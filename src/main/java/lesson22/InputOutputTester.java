package lesson22;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputTester {

    // Introduction to Input and Output in Java.
    // https://i0.wp.com/javaconceptoftheday.com/wp-content/uploads/2022/04/ByteStreamVsCharacterStreamInJava.png
    // https://www3.ntu.edu.sg/home/ehchua/programming/java/images/IO_LayeredInput.png

    public static void main(String[] args) throws IOException {


        byte[] data = new byte[10];
        System.out.println("Please enter some characters");
        int number = System.in.read(data);
        System.out.println("You entered " + number + " of chars");
        for (int i = 0; i < number; i++) {
            System.out.print((char) data[i]);
        }

//        FileOutputStream fileOutputStream = new FileOutputStream("result.txt");
//        // TODO делаем что-то файлом
//        fileOutputStream.flush();
//        fileOutputStream.close();

        try (FileOutputStream fileOutputStream = new FileOutputStream("result.txt")) {
            // файл автоматически закроется после выхода из try блока
            for (int i = 0; i < number; i++) {
                fileOutputStream.write(data[i]);
            }
        }


    } // end of main

}