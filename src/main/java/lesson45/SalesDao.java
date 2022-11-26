package lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class SalesDao {

    private static final String URL = "jdbc:sqlite:shop.db";
    private static final String insert = "insert into salespeople values (?, ?, ?, ?);";
    private static final String delete = "delete from salespeople where snum = ?;";
    private static final String selectCity = "select * from salespeople where city = ?;";
    private static final String selectSales = "select * from salespeople where snum= ?;";

    private final Statement selectStatement;
    private final PreparedStatement selectCityPreparedStatement;
    private final PreparedStatement selectSalesByIdStatement;
    private final PreparedStatement insertStatement;
    private final PreparedStatement deleteStatement;

    public SalesDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);

        // может быть лучше эти параметризованные запросы перенести в соответствующие методы??
        insertStatement = conn.prepareStatement(insert);
        deleteStatement = conn.prepareStatement(delete);
        selectStatement = conn.createStatement();
        selectSalesByIdStatement = conn.prepareStatement(selectSales);
        selectCityPreparedStatement = conn.prepareStatement(selectCity);
        //
    }

    // сохраняет в базу данных
    public Sales save(Sales sales) throws SQLException {
        insertStatement.setInt(1, sales.getId());
        insertStatement.setString(2, sales.getName());
        insertStatement.setString(3, sales.getCity());
        insertStatement.setInt(4, sales.getCommission());
        insertStatement.execute();
        return sales;
    }

    public void delete(Sales sales) throws SQLException {
        deleteStatement.setInt(1, sales.getId());
        deleteStatement.execute();
    }

    public Sales getSalesById(int snum) throws SQLException {
        Sales sales = null;
        selectCityPreparedStatement.setInt(1, snum);
        try (
                ResultSet rs = selectCityPreparedStatement.executeQuery();
        ) {
            if (rs.next()) {
                sales =
                        new Sales(
                                rs.getInt("snum"),
                                rs.getString("sname"),
                                rs.getString("citytext"),
                                rs.getInt("comm")
                        );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return sales;
    }

    public List<Sales> getAll() throws SQLException {
        List<Sales> result = new ArrayList<>();
        try (ResultSet rs = selectStatement.executeQuery("select * from salespeople;");) {
            while (rs.next()) {
                result.add(
                        new Sales(
                                rs.getInt("snum"),
                                rs.getString("sname"),
                                rs.getString("city"),
                                rs.getInt("comm")
                        )
                );
            }
        }
        return result;
    }

    public List<Sales> getAllByCity(String city) throws SQLException {
        List<Sales> salesCityList = new ArrayList<>();
        selectCityPreparedStatement.setString(1, city);
        ResultSet rs = selectCityPreparedStatement.executeQuery();
        while (rs.next()) {
            salesCityList.add(
                    new Sales(
                            rs.getInt("snum"),
                            rs.getString("sname"),
                            rs.getString("city"),
                            rs.getInt("comm")
                    )
            );
        }
        return salesCityList;
    }
}