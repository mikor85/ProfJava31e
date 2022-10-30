package lesson25;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson25 {
    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("2.");  -> 23
        //Pattern pattern = Pattern.compile("paint.");  -> 0
        //Pattern pattern = Pattern.compile("was\\.");  -> 1
        //Pattern pattern = Pattern.compile("max|was|d"); -> 5
        //Pattern pattern = Pattern.compile("[23]");  -> 2
        //Pattern pattern = Pattern.compile("[^23]"); -> 54
        //Pattern pattern = Pattern.compile("[1-3][2-8]"); -> 2
        //Pattern pattern = Pattern.compile("\\d\\d");  -> 3
        //Pattern pattern = Pattern.compile("(.as(...))");
        Pattern pattern = Pattern.compile("\\bmax");

        Matcher matcher = pattern.matcher("Today's max 38 temperature was. 23 as measured 333 by maxpaint");

        System.out.println("hello".replaceAll("ll", ""));

        System.out.println(
                Arrays.toString(
                        "hello".split("")
                )
        );

        System.out.println("----------");
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.printf("group %d is |%s|\n", i, matcher.group());
            }
        }

        System.exit(1);

        // System.out.println(matcher.find());  // есть ли вхождения шаблона в строку
        System.out.println(matcher.results().count()); // сколько раз шаблон встретился в строке

        System.out.println("----ip----");
        System.out.println(isIpV4Address("1.1.1.1"));         // true
        System.out.println(isIpV4Address("1.a.1.1"));         // false
        System.out.println(isIpV4Address("3333.22.33.1"));    // false
        System.out.println(isIpV4Address("222.222.222.222")); // true

        System.out.println("----pin----");
        System.out.println(isPinCode("1111"));   // true
        System.out.println(isPinCode("22"));     // false
        System.out.println(isPinCode("a333"));   // false
        System.out.println(isPinCode("888888")); // true
        System.out.println(isPinCode("aa8888")); // false

        System.out.println("----car number----");
        System.out.println(isCarNumber("3333 AA")); // true
        System.out.println(isCarNumber("3333 aa")); // false
        System.out.println(isCarNumber("33335 AA")); // false
        System.out.println(isCarNumber("3335 A5")); // false

        System.out.println("----hex number----");
        System.out.println(isHexNumber("0xaf345")); // true
        System.out.println(isHexNumber("0XFCD")); // true
        System.out.println(isHexNumber("0x123")); // true
        System.out.println(isHexNumber("0123")); // false
        System.out.println(isHexNumber("0xGHE")); // false

        // hello.png -> png
        // my.resume.1.doc -> doc
        System.out.println("----file extension----");
        System.out.println(getExtension("hello.png"));
        System.out.println(getExtension("my.resume.1.doc"));

    }

    public static String getExtension(String fileName) {
        String[] parts = fileName.split("\\.");
        return parts[parts.length - 1];
    }

    public static boolean isHexNumber(String number) {
        // 0xaf345
        // 0XFCD
        // 0x123
        // 0 + x или X + цифра или буквы A-F в нижнем или верхнем регистре
        //return number.matches("0[xX][a-fA-F_0-9]+");
        return number.matches("0[xX][0-9A-Fa-f]+");
    }

    public static boolean isCarNumber(String number) {
        return number.matches("\\d{4}\\s[A-Z]{2}");
        //return number.matches("\\d{4}\\s[A-Z][A-Z]");
    }

    public static boolean isPinCode(String code) {
        return code.matches("\\d{4}|\\d{6}");
    }

    public static boolean isIpV4Address(String address) {
        return address.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }
}