package repos;

import daoApi.Dao;
import entity.Order;
import properties.PropertiesDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements Dao<Order> {
    private final PropertiesDB prop;
    private final List<Order> orderList = new ArrayList<>();

    public OrderImpl(PropertiesDB prop) {
        this.prop = prop;
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public void add(Order order) {
        if (orderList.stream().noneMatch(i -> i.getCustomerId() == order.getCustomerId() &&
                i.getProductId() == order.getProductId() && i.getOrderDate().equals(order.getOrderDate()))){
            orderList.add(order);
        } else return;
        try(Connection con = DriverManager.getConnection(prop.getUrl(), prop.getLogin(), prop.getPassword())) {
            String query = "INSERT INTO order_(id_customer,id_product,order_date) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, order.getCustomerId());
            preparedStatement.setInt(2,order.getProductId());
            preparedStatement.setDate(3, Date.valueOf(order.getOrderDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
