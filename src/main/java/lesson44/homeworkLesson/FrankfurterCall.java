package lesson44.homeworkLesson;

import lesson34.Rate;
import lesson34.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FrankfurterCall {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into currency (amount, f, t, result) values (?,?,?,?);"
                );
        ) {
            Rate usdToGbp = Request.getRate(15, "USD", "GBP");
            stmt.setDouble(1, usdToGbp.amount);
            stmt.setString(2, usdToGbp.base);
            stmt.setString(3, "GBP");
            stmt.setDouble(4, usdToGbp.rates.get("GBP"));
            stmt.execute();

            Rate usdToEur = Request.getRate(50, "USD", "EUR");
            stmt.setDouble(1, usdToEur.amount);
            stmt.setString(2, usdToEur.base);
            stmt.setString(3, "EUR");
            stmt.setDouble(4, usdToEur.rates.get("EUR"));
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}