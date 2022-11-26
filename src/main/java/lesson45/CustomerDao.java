package lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// cnum   city  cname  rating  snum

public class CustomerDao {
    private static final String URL = "jdbc:sqlite:shop.db";
    private static final String insert = "insert into customers values (?, ?, ?, ?, ?);";
    private static final String delete = "delete from customers where cnum = ?;";
    private static final String selectSales = "select * from customers where snum = ?;";
    private static final String selectCity = "select * from customers where city = ?;";
    private final Statement selectStatement;
    private final PreparedStatement selectSalesPreparedStatement;
    private final PreparedStatement selectCityPreparedStatement;
    private final PreparedStatement insertStatement;
    private final PreparedStatement deleteStatement;

    public CustomerDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);

        insertStatement = conn.prepareStatement(insert);
        deleteStatement = conn.prepareStatement(delete);
        selectStatement = conn.createStatement();
        selectSalesPreparedStatement = conn.prepareStatement(selectSales);
        selectCityPreparedStatement = conn.prepareStatement(selectCity);
    }

    public Customer save(Customer customer) throws SQLException {
        insertStatement.setInt(1, customer.getId());
        insertStatement.setString(2, customer.getName());
        insertStatement.setString(3, customer.getCity());
        insertStatement.setInt(4, customer.getRating());
        insertStatement.setInt(5, customer.getSales().getId());
        insertStatement.execute();
        return customer;
    }

    public void delete(Customer customer) throws SQLException {
        deleteStatement.setInt(1, customer.getId());
        deleteStatement.execute();
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> result = new ArrayList<>();
        try (ResultSet rs = selectStatement.executeQuery("select * from customers;");) {
            while (rs.next()) {
                result.add(
                        new Customer(
                                rs.getInt("cnum"),
                                rs.getString("cname"),
                                rs.getString("city"),
                                rs.getInt("rating"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }

    public List<Customer> getAllBySales(Sales sales) throws SQLException {
        List<Customer> customersBySalesList = new ArrayList<>();
        selectSalesPreparedStatement.setInt(1, sales.getId());
        ResultSet rs = selectSalesPreparedStatement.executeQuery();
        while (rs.next()) {
            customersBySalesList.add(
                    new Customer(
                            rs.getInt("cnum"),
                            rs.getString("cname"),
                            rs.getString("city"),
                            rs.getInt("rating"),
                            rs.getInt("snum")
                    )
            );
        }
        return customersBySalesList;
    }

    public List<Customer> getAllByCity(String city) throws SQLException {
        List<Customer> customersByCityList = new ArrayList<>();
        selectCityPreparedStatement.setString(1, city);
        ResultSet rs = selectCityPreparedStatement.executeQuery();
        while (rs.next()) {
            customersByCityList.add(
                    new Customer(
                            rs.getInt("cnum"),
                            rs.getString("cname"),
                            rs.getString("city"),
                            rs.getInt("rating"),
                            rs.getInt("snum")
                    )
            );
        }
        return customersByCityList;
    }

    public List<Customer> getCustomersByRs(ResultSet rs) throws SQLException {
        SalesDao salesDao = new SalesDao();
        List<Customer> result = new ArrayList<>();
        while (rs.next()) {
            Sales sales = salesDao.getSalesById(rs.getInt("snum"));
            result.add(
                    new Customer(
                            rs.getInt("cnum"),
                            rs.getString("cname"),
                            rs.getString("citytext"),
                            rs.getInt("rating"),
                            sales
                    )
            );
        }
        return result;
    }
}