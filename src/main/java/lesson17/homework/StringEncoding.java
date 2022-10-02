package lesson17.homework;

// 1. Напишите метод для кодирования строк. Строка состоит только из маленьких латинских букв.
// Пример: "aaaabbcccdaaa" -> "4a2b3c1d3a".
// 2. * Напишите метод для декодирования такой строки.
// 3. * Напишите метод, который вернет true если в массиве присутствуют два числа,
// произведение которых даст нужное число. Пример [5,7,12, 2] , 10 -> true:
// => public static boolean test(int [] a, int b)

public class StringEncoding {
    public static void main(String[] args) {

        // Task Nr.1:
        System.out.println("Task Nr.1:");
        String sToEncode = "aaaabbcccdaaaxxxx";
        System.out.println(getStringEncoding(sToEncode));
        System.out.println("----------");

        // Task Nr.2:
        System.out.println("Task Nr.2:");
        String sToDecode = "4a2b3c1d3a4x";
        System.out.println(getDecodedString("4a2b3c1d3a4x"));

    }

    private static String getStringEncoding(String s) {
        if (s.length() == 0) {
            return "Введенная строка пустая";
        }
        StringBuilder result = new StringBuilder();
        char currentChar = s.charAt(0);
        int counter = 1;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == currentChar) {
                counter++;
                currentChar = s.charAt(i);
            } else {
                result.append(counter).append(currentChar);
                currentChar = s.charAt(i);
                counter = 1;
            }
        }
        result.append(counter).append(currentChar);
        return result.toString();
    }

    public static String getDecodedString(String s) {
        if (s.length() == 0) {
            return "Введенная строка пустая";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i += 2) {
            int currentNumber = Character.getNumericValue(s.charAt(i));
            char currentChar = s.charAt(i + 1);
            result.append(String.valueOf(currentChar).repeat(Math.max(0, currentNumber)));
        }
        return result.toString();
    }
}