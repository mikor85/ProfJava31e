package lesson46;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTester {
    private static final String URL = "jdbc:sqlite:shop.db";
    private static final String insert = "insert into user (first, last, age) values (?, ?, ?);";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(insert);
            // делаем что-то с таблицами базы данных
            statement.setString(1, "Alex");
            statement.setString(2, "Pavlov");
            statement.setInt(3, 22);
            int affectedRows = statement.executeUpdate(); // количество "затронутых" строк в таблице
            if (1 == 0) {
                throw new RuntimeException("exception");
            }
            statement.setString(1, "Elena");
            statement.setString(2, "Kruglova");
            statement.setInt(3, 23);
            affectedRows = statement.executeUpdate();     // количество "затронутых" строк в таблице

            conn.commit();  // все изменения становятся видны другим соединениям
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            if (conn != null) {
                conn.rollback();  // откат всех изменений
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}