package lesson44;

import java.sql.*;

public class D_Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";  // создаем базу данных в корне проекта
        try (
                // установка соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                Statement stmt = conn.createStatement();
                // ResultSet - окошко в содержимое результата запроса
                ResultSet rs = stmt.executeQuery("select * from salespeople;");
                // Подготовленный запрос с параметром
                PreparedStatement pstmt = conn.prepareStatement("select * from salespeople where comm > ?");
        ) {
            while (rs.next()) {
                int snum = rs.getInt("snum");
                String sname = rs.getString("sname");
                String city = rs.getString("citytext");
                int comm = rs.getInt("comm");

                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }

            pstmt.setInt(1, 14);

            System.out.println("----------");
            ResultSet rs1 = pstmt.executeQuery();

            while (rs1.next()) {
                int snum = rs1.getInt("snum");
                String sname = rs1.getString("sname");
                String city = rs1.getString("citytext");
                int comm = rs1.getInt("comm");

                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }


        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}