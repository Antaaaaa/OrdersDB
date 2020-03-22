package repos;

import daoApi.Dao;
import entity.Customer;
import properties.PropertiesDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements Dao<Customer> {
    private final PropertiesDB prop;
    private final List<Customer> customerList = new ArrayList<>();

    public CustomerImpl(PropertiesDB prop) {
        this.prop = prop;
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    public void add(final Customer customer) {
        if (customerList.stream().noneMatch(i -> i.getPhone().equals(customer.getPhone()))){
            customerList.add(customer);
        } else return;
        try (Connection con = DriverManager.getConnection(prop.getUrl(), prop.getLogin(), prop.getPassword())) {
            String query = "INSERT INTO customer(customer_name,phone,address) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
