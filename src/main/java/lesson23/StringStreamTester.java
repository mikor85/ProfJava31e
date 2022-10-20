package lesson23;

import java.io.BufferedReader;
import java.io.StringReader;

public class StringStreamTester {
    // https://www.oreilly.com/api/v2/epubs/9781449372477/files/httpatomoreillycomsourceoreillyimages1707640.png

    // https://www.oreilly.com/api/v2/epubs/9781449372477/files/httpatomoreillycomsourceoreillyimages1707642.png

    public static void main(String[] args) {
        String hello = "hello\nworld\nhow are you?";
        StringReader stringReader = new StringReader(hello);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        bufferedReader.lines().forEach(System.out::println);
    }
}