import entity.Customer;
import entity.Order;
import entity.Product;
import properties.PropertiesDB;
import repos.CustomerImpl;
import repos.OrderImpl;
import repos.ProductImpl;

public class Main {
    public static void main(String[] args){
        PropertiesDB propertiesDB = new PropertiesDB();
        Customer customer1 = new Customer("Anatoliy", "0661212333", "Kiev");
        Product product1 = new Product("Whiskey", 800, "Jack Daniel's Tennessee Honey"+
                "features a light, sweet honeyed aroma.This is marked with undertones of that classic, sugar maple and"+
                " charcoal-mellowed fragrance that we've come to know and love about JD.The liqueur has the same body "+
                "and mouthfeel as classic Jack Daniel's.");
        Order order1 = new Order(1, 1, "2020-03-22");

        CustomerImpl customer = new CustomerImpl(propertiesDB);
        ProductImpl product = new ProductImpl(propertiesDB);
        OrderImpl order = new OrderImpl(propertiesDB);

        customer.add(customer1);
        product.add(product1);
        order.add(order1);
    }
}
