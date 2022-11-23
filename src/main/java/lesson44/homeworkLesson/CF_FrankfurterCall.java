package lesson44.homeworkLesson;

import lesson34.Rate;
import lesson34.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CF_FrankfurterCall {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Rate usdToGbp = Request.getRate(15, "USD", "GBP");
//        saveRate(usdToGbp.amount, usdToGbp.base, "GBP", usdToGbp.rates.get("GBP"));
//        Rate usdToEur = Request.getRate(50, "USD", "EUR");
//        saveRate(usdToGbp.amount, usdToGbp.base, "EUR", usdToGbp.rates.get("EUR"));

        // Runnable - функция, которую можно переиспользовать, запуская на Thread'ах;
        // Thread - параллельный поток выполнения;
        // ExecutorService - пул Thread-ов - набор потоков + очередь из Runnable;
        // Future - результат, возвращаемый Callable;
        // CompletableFuture - Future, которые можно мультиплексировать между собой и выполнять
        // параллельно либо последовательно, при желании на ExecutorService.

        CompletableFuture<Rate> usdToEur = CompletableFuture.supplyAsync(
                () -> Request.getRate(150, "EUR", "GBP")
        );

        CompletableFuture<Void> res = usdToEur.thenAccept(
                rate -> saveRate(rate.amount, rate.base, "GBP", rate.rates.get("GBP"))
        );

        res.get();
    }

    public static void saveRate(double amount, String f, String t, double result) {

        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into currency (amount, f, t, result) values (?,?,?,?);"
                );
        ) {

            stmt.setDouble(1, amount);
            stmt.setString(2, f);
            stmt.setString(3, t);
            stmt.setDouble(4, result);
            stmt.execute();

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}