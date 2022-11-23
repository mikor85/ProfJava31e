package lesson45;

import java.sql.SQLException;
import java.util.List;

public class DaoTester {
    public static void main(String[] args) throws SQLException {

        SalesDao salesDao = new SalesDao();
        CustomerDao customerDao = new CustomerDao();
        OrderDao orderDao = new OrderDao();

        // SALESPEOPLE
        Sales max = new Sales(4001, "Max", "Warsaw", 12);
        Sales alex = new Sales(4002, "Alex", "Berlin", 14);

        // CUSTOMERS
        Customer robby = new Customer(5001, "Robby", "Paris", 300, max);
        Customer john = new Customer(5002, "John", "Rome", 350, alex);
        Customer konstantin = new Customer(5003, "Konstantin", "Moscow", 250, max);
        Customer ivan = new Customer(5004, "Ivan", "Moscow", 300, alex);

        // ORDERS
        Order nr6001 = new Order(6001, 250_000, robby, "2022-11-01", max);
        Order nr6002 = new Order(6002, 150_000, john, "2022-11-01", max);
        Order nr6003 = new Order(6003, 200_000, konstantin, "2022-11-01", max);
        Order nr6004 = new Order(6004, 300_000, ivan, "2022-11-01", max);
        Order nr6005 = new Order(6005, 400_000, robby, "2022-11-01", alex);
        Order nr6006 = new Order(6006, 500_000, john, "2022-11-01", alex);
        Order nr6007 = new Order(6007, 600_000, konstantin, "2022-11-01", alex);
        Order nr6008 = new Order(6008, 550_000, ivan, "2022-11-01", alex);


        // SALES => Check method save

//        salesDao.save(max);
//        salesDao.save(alex);

        // SALES => Check method delete
//        salesDao.delete(max);
//        salesDao.delete(alex);

        // SALES => Check method getAll
        System.out.println("----------");
        List<Sales> allSales = salesDao.getAll();
        allSales.forEach(
                sales -> System.out.println(sales.getName())
        );

        // SALES => Check method getAllByCity
        System.out.println("----------");
        List<Sales> allSalesInCity = salesDao.getAllByCity("London");
        allSalesInCity.forEach(System.out::println);

        // CUSTOMERS => Check method save
//        System.out.println("----------");
//        customerDao.save(robby);
//        customerDao.save(john);
//        customerDao.save(konstantin);
//        customerDao.save(ivan);

        // CUSTOMERS => Check method delete
//        customerDao.delete(robby);
//        customerDao.delete(john);
//        customerDao.delete(konstantin);
//        customerDao.delete(ivan);

        // CUSTOMERS => Check method getAll
        System.out.println("----------");
        List<Customer> allCustomers = customerDao.getAll();
        allCustomers.forEach(customer -> System.out.println(
                customer.getId() + " " +
                        customer.getName() + " " +
                        customer.getCity() + " " +
                        customer.getRating()));

        // CUSTOMERS => Check method getAllBySales
        System.out.println("----------");
        List<Customer> allCustomersBySales = customerDao.getAllBySales(max);
        allCustomersBySales.forEach(customer -> System.out.println(
                customer.getId() + " " +
                        customer.getName() + " " +
                        customer.getCity() + " " +
                        customer.getRating()));

        // CUSTOMERS => Check method getAllByCity
        System.out.println("----------");
        List<Customer> allCustomersByCity = customerDao.getAllByCity("Moscow");
        allCustomersByCity.forEach(customer -> System.out.println(
                customer.getId() + " " +
                        customer.getName() + " " +
                        customer.getCity() + " " +
                        customer.getRating()));

        // ORDERS => Check method save
//        System.out.println("----------");
//        orderDao.save(nr6001);
//        orderDao.save(nr6002);
//        orderDao.save(nr6003);
//        orderDao.save(nr6004);
//        orderDao.save(nr6005);
//        orderDao.save(nr6006);
//        orderDao.save(nr6007);
//        orderDao.save(nr6008);

        // ORDERS => Check method delete
//        orderDao.delete(nr6001);
//        orderDao.delete(nr6002);
//        orderDao.delete(nr6003);
//        orderDao.delete(nr6004);
//        orderDao.delete(nr6005);
//        orderDao.delete(nr6006);
//        orderDao.delete(nr6007);
//        orderDao.delete(nr6008);

        // ORDERS => Check method getAll
        System.out.println("----------");
        List<Order> allOrders = orderDao.getAll();

        allOrders.forEach(order -> System.out.println(
                order.getId() + " " +
                        order.getSum() + " " +
                        order.getCustomerId() + " " +
                        order.getDate() + " " +
                        order.getSalesId()));

        // ORDERS => Check method getAllBySales
        System.out.println("----------");
        List<Order> allOrdersBySales = orderDao.getAllBySales(max);
        allOrdersBySales.forEach(order -> System.out.println(
                order.getId() + " " +
                        order.getSum() + " " +
                        order.getCustomerId() + " " +
                        order.getDate() + " " +
                        order.getSalesId()));

        // ORDERS => Check method getAllByCustomer

        // ORDERS => Check method getAllByCity

        // ORDERS => Check method getAllByDate

    }
}