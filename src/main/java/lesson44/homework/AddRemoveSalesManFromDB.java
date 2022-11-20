package lesson44.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddRemoveSalesManFromDB {
    public static void main(String[] args) {
        //addSalesManager(1008, "Ivan", "Moscow", 13);

        removeSalesManager(1008);
    }

    public static void addSalesManager(int snum, String sname, String citytext, int comm) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            statement.execute("insert into salespeople values (" +
                    snum + ", '" +
                    sname + "', '" +
                    citytext + "', " +
                    comm + ");");

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }

    public static void removeSalesManager(int snum) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            statement.execute("delete from salespeople where snum = " + snum + ";");

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}