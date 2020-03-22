package repos;

import daoApi.Dao;
import entity.Product;
import org.omg.SendingContext.RunTime;
import properties.PropertiesDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements Dao<Product> {
    private final PropertiesDB prop;
    private final List<Product> productList = new ArrayList<>();
    public ProductImpl(PropertiesDB prop) {
        this.prop = prop;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        if (productList.stream().noneMatch(i -> i.getProductName().equals(product.getProductName()))){
            productList.add(product);
        } else return;
        try(Connection con = DriverManager.getConnection(prop.getUrl(), prop.getLogin(), prop.getPassword())) {
            String query = "INSERT INTO product(product_name,price,characteristic) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setString(3, product.getCharacteristic());
            preparedStatement.executeUpdate();
    } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
