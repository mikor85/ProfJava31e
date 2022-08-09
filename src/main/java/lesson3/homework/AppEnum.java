package lesson3.homework;

// ДЗ проф ява
// 1. Создайте перечисление Weekday дней недели - MONDAY, ..., SUNDAY.
// Напишите в этом перечислении функции isWeekDay():true - является ли день рабочим
// и функцию isWeekEnd(): true - является ли день выходным.

// 2. Создайте перечисление Cru. BASE(80), PREMIER(90), GRAND(100).
// Добавьте поле quality:int и добавьте конструктор.

import static lesson3.homework.Weekday.MONDAY;

public class AppEnum {

    Day d1 = new Day(MONDAY);
    d1.isWeekDay();

}
