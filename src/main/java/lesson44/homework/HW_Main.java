package lesson44.homework;

import java.util.List;

public class HW_Main {
    public static void main(String[] args) {

        // Task Nr.1:
        // Добавьте нового продавца, потом удалите его.

        //AddRemoveSalesManFromDB.addSalesManager(1008, "Ivan", "Moscow", 13);

        //AddRemoveSalesManFromDB.removeSalesManager(1008);

        //---------------------//

        // Task Nr.2:
        // Создайте новый проект и сохраните в базу данных результаты нескольких вызовов
        // веб-сервиса frankfurter с разными параметрами.
        double amount = 100;
        String convertFrom = "USD";
        String convertTo = "EUR";
        //RequestToFrankfurter.addRateInDB(amount, convertFrom, convertTo);
        //RequestToFrankfurter.removeRowRateFromDB(amount);

        //---------------------//

        // Task Nr.3:
        // Сделайте через CompletableFuture и запрос и сохранение результата в базу данных.

        //RequestToFrankfurter.addRateFromCompletableFuture(amount, convertFrom, convertTo);

        //---------------------//

        // Task Nr.4:
        // С помощью Stream-ов посчитайте сумму нечетных элементов массива целых -
        // воспользуйтесь IntStream.range(0, ...) для генерации последовательности номеров элементов -
        // подумайте, как превратить их в нечетные числа?
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(GetSumOfOddElements.getSum(arr));

        //---------------------//

        // Task Nr.5:
        // С помощью Stream-ов отсортируйте список строк, сравнив их по подстрокам со ВТОРОГО символа по последний.
        // Т.е., для элемента "Max" подстрока для сравнения должна быть "ax".
        List<String> strings = List.of(
                "Max is programmer",
                "Our product manager Alex is professional",
                "New project is interesting",
                "In our company nice colleagues"
        );
        System.out.println(SortListStringStream.sortListString(strings));

        //---------------------//

        // Task Nr.6:
        // 6. С помощью Stream-ов отфильтруйте список строк, распечатав только те из них,
        // которые являются палиндромами - т.е., одинаково выглядят при чтении вперед и назад - например, "алла".
        List<String> stringList = List.of("Max", "Alla alla", "Лёша на полке клопа нашёл", "Аргентина манит негра");
        GetPalindrome.getPalindrome(stringList);
    }
}