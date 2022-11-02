package lesson25.homework;

// ДЗ проф ява:
// 1. Напишите метод, который удаляет из строки все гласные в любом регистре.

// 2. Напишите метод, который проверяет, что строка является телефонным номером -
// номер начинается с опционального плюса, а дальше 6 цифр.

// 3. **Если в строке встречается число без десятичной точки, то добавьте этой цифре ".0".
// Пример: "расходы 20 доходы 50.3" -> "расходы 20.0 доходы 50.3".

public class MatchesMethodHomework {
    public static void main(String[] args) {

        // Task Nr.1:
        System.out.println("-----remVowels-----");
        System.out.println(deleteAllVowelsFromString("Hello World"));
        System.out.println(deleteAllVowelsFromString("HELLO WORLD!"));
        System.out.println(deleteAllVowelsFromString("А роза упала на лапу Азора"));

        // Task Nr.2:
        System.out.println("-----checkTelNumber-----");
        System.out.println(checkTelNumber("+777777"));  // true
        System.out.println(checkTelNumber("+8888888")); // false
        System.out.println(checkTelNumber("999999"));   // true

        // Task Nr.3:
        System.out.println("-----addDecimalPoint-----");
        String s = "было 29.7 расходы 20 доходы 50.3 в остатке 60";
        System.out.println(addDecimalPointToDouble(s));
        System.out.println(mapIntDouble(s));
    }

    // Task Nr.1:
    public static String deleteAllVowelsFromString(String string) {
        return string.replaceAll("[aeiouаеиоуыэюяAEIOUАЕИОУЫЭЮЯ]", "");
    }

    // Task Nr.2:
    public static boolean checkTelNumber(String telNumber) {
        return telNumber.matches("\\+?\\d{6}");  // ? - 0 или 1
    }

    // Task Nr.3:
    public static String mapIntDouble(String s) {
        //                           1    2    3
        return s.replaceAll("(\\s|^)(\\d+)(\\s|$)", "$1$2.0$3");
    }


    public static String addDecimalPointToDouble(String string) {
        StringBuilder result = new StringBuilder();
        String[] arrStr = string.split("\\s");
        for (String s : arrStr) {
            if (s.matches("\\d+") && !s.contains(".")) {
                result.append(s).append(".0").append(" ");
            } else result.append(s).append(" ");
        }
        return result.toString();
    }
}