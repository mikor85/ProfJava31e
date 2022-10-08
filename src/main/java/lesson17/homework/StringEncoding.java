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
        System.out.println(encode(sToEncode));
        System.out.println("----------");

        // Task Nr.2:
        System.out.println("Task Nr.2:");
        String sToDecode = "4a2b3c1d3a4x";
        System.out.println(getDecodedString("4a2b3c1d3a4x"));
        System.out.println("----------");
        System.out.println(decode("4a2b3c1d3a"));
    }

    public static String encode(String input) {
        StringBuilder b = new StringBuilder();
        char[] letters = input.toCharArray();
        int counter = 0;
        char prev = letters[0];
        char curr = letters[0];
        for (char c : letters) {
            curr = c;
            if (curr != prev) {
                b.append(counter).append(prev);
                counter = 1;
            } else {
                counter++;
            }
            prev = curr;
        }
        b.append(counter).append(curr);
        return b.toString();
    }

    // My realization
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

    public static String decode(String crypto) {
        // разбиваем на символы
        // в цикле если символ цифра, добавляем его в строку с цифрами
        // вв цикле добавляем в builder нужное кол-во букв
        StringBuilder r = new StringBuilder();  // результат
        String d = "";
        char[] letters = crypto.toCharArray();
        for (Character c : letters) {
            if (!Character.isDigit(c)) {
                int numberOfLetters = Integer.parseInt(d);
                for (int i = 0; i < numberOfLetters; i++) {
                    r.append(c);
                }
                d = "";
            } else {
                d += c;
            }
        }
        return r.toString();
    }

    // My realization
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