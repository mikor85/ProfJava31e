package lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String URL = "jdbc:sqlite:shop.db";
    private static final String insert = "insert into orders values (?, ?, ?, ?, ?);";
    private static final String delete = "delete from orders where onum = ?;";
    private static final String selectSales = "select * from orders where snum in (select sname from salespeople where sname = ?);";
    //private static final String selectCustomers = "select * from orders where cnum = ?;";
    //private static final String selectCity = "select * from orders where (select * from customer where cnum = ?);";
    //private static final String selectDate = "select * from orders where odate = ?;";
    private final Statement selectStatement;
    private final PreparedStatement selectSalesPreparedStatement;
    //private final PreparedStatement selectCustomersPreparedStatement;
    //private final PreparedStatement selectCityPreparedStatement;
    //private final PreparedStatement selectDatePreparedStatement;
    private final PreparedStatement insertStatement;
    private final PreparedStatement deleteStatement;

    public OrderDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);

        insertStatement = conn.prepareStatement(insert);
        deleteStatement = conn.prepareStatement(delete);
        selectStatement = conn.createStatement();
        selectSalesPreparedStatement = conn.prepareStatement(selectSales);
        //selectCustomersPreparedStatement = conn.prepareStatement(selectCustomers);
        //selectCityPreparedStatement = conn.prepareStatement(selectCity);
        //selectDatePreparedStatement = conn.prepareStatement(selectDate);
    }

    public Order save(Order order) throws SQLException {
        insertStatement.setInt(1, order.getId());
        insertStatement.setInt(2, order.getSum());
        insertStatement.setString(3, order.getDate());
        insertStatement.setInt(4, order.getCustomer().getId());
        insertStatement.setInt(5, order.getSales().getId());
        insertStatement.execute();
        return order;
    }

    public void delete(Order order) throws SQLException {
        deleteStatement.setInt(1, order.getId());
        deleteStatement.execute();
    }

    public List<Order> getAll() throws SQLException {
        List<Order> result = new ArrayList<>();
        try (ResultSet rs = selectStatement.executeQuery("select * from orders;")) {
            while (rs.next()) {
                result.add(
                        new Order(
                                rs.getInt("onum"),
                                rs.getInt("amt"),
                                rs.getInt("cnum"),
                                rs.getString("odate"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }

    public List<Order> getAllBySales(Sales sales) throws SQLException {
        List<Order> ordersBySalesList = new ArrayList<>();
        selectSalesPreparedStatement.setString(1, sales.getName());
        ResultSet rs = selectSalesPreparedStatement.executeQuery();
        while (rs.next()) {
            ordersBySalesList.add(
                    new Order(
                            rs.getInt("onum"),
                            rs.getInt("amt"),
                            rs.getInt("cnum"),
                            rs.getString("odate"),
                            rs.getInt("snum")
                    )
            );
        }
        return ordersBySalesList;
    }

    public List<Order> getAllByCustomer(Customer customer) {

        return null;
    }

    public List<Order> getAllByCity(String city) {

        return null;
    }

    public List<Order> getAllByDate(String date) {

        return null;
    }
}