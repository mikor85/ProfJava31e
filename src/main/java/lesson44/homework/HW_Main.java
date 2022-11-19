package lesson44.homework;

// ДЗ проф ява:


// 2. Создайте новый проект и сохраните в базу данных результаты нескольких вызовов
// веб-сервиса frankfurter с разными параметрами.

// 3.* Сделайте через CompletableFuture и запрос и сохранение результата в базу данных.

// 4. С помощью Stream-ов посчитайте сумму нечетных элементов массива целых -
// воспользуйтесь IntStream.range(0, ...) для генерации последовательности номеров элементов -
// подумайте, как превратить их в нечетные числа?

// 5. С помощью Stream-ов отсортируйте список строк, сравнив их по подстрокам со ВТОРОГО символа по последний.
// Т.е., для элемента "Max" подстрока для сравнения должна быть "ax".

// 6. С помощью Stream-ов отфильтруйте список строк, распечатав только те из них,
// которые являются палиндромами - т.е., одинаково выглядят при чтении вперед и назад - например, "алла".

public class HW_Main {
    public static void main(String[] args) {

        // Task Nr.1:
        AddRemoveSalesManFromDB.addSalesManager(1008, "Ivan", "Moscow", 13);

        //AddRemoveSalesManFromDB.removeSalesManager(1008);

        // Task Nr.2:
        double amount = 100;
        String convertFrom = "USD";
        String convertTo = "EUR";
        //RequestToFrankfurter.addRateInDB(amount, convertFrom, convertTo);
        //RequestToFrankfurter.removeRowRateFromDB(amount);

        // Task Nr.3:
        RequestToFrankfurter.addRateFromCompletableFuture(amount, convertFrom, convertTo);

    }
}