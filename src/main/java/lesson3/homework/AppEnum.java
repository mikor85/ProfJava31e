package lesson3.homework;

// ДЗ проф ява
// 1. Создайте перечисление Weekday дней недели - MONDAY, ..., SUNDAY.
// Напишите в этом перечислении функции isWeekDay():true - является ли день рабочим
// и функцию isWeekEnd(): true - является ли день выходным.

// 2. Создайте перечисление Cru. BASE(80), PREMIER(90), GRAND(100).
// Добавьте поле quality:int и добавьте конструктор.

public class AppEnum {
    public static void main(String[] args) {
        Weekday wd1 = Weekday.MONDAY;
        System.out.println(wd1.isWeekEnd());

        System.out.println(wd1.getWeekdayValue());

        System.out.println(Weekday.MONDAY.isWeekDay());
        System.out.println(Weekday.SUNDAY.isWeekEnd());

        Weekday m = Weekday.MONDAY;

        Cru g = Cru.valueOf("GRAND");
        System.out.println(g.getQuality());

        // Cru no = Cru.valueOf("NO"); // IllegalArgumentException
        // System.out.println(no);

    }

}
