package lesson44.homeworkLesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDelete {
    public static void main(String[] args) {
        //addSales(2001, "Cristo", "Warsaw", 12);
        delete(2001);
    }

    public static void delete(int snum) {
        // insert into salespeople (snum, sname, citytext, comm) values (1021, 'smith', 'warsaw', 11);
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement("delete from salespeople where snum = ?;");
        ) {
            pstmt.setInt(1, snum);
            pstmt.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void addSales(int snum, String sname, String citytext, int comm) {
        // insert into salespeople (snum, sname, citytext, comm) values (1021, 'smith', 'warsaw', 11);
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                PreparedStatement pstmt = conn.prepareStatement("insert into salespeople (snum, sname, citytext, comm) values (?, ?, ?, ?);");
        ) {
            pstmt.setInt(1, snum);
            pstmt.setString(2, sname);
            pstmt.setString(3, citytext);
            pstmt.setInt(4, comm);
            pstmt.execute();
            // comm = 12; drop table salespeople;
            // insert into .... 12; drop table salespeople;
            // stmt.execute("insert into salespeople (snum, sname, citytext, comm) values (1021, 'smith', 'warsaw', 11);");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}