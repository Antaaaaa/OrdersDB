package entity;

public class Product {
    private int id;
    private String productName;
    private long price;
    private String characteristic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Product(String productName, long price) {
        this.productName = productName;
        this.price = price;
    }

    public Product(String productName, long price, String characteristic) {
        this.productName = productName;
        this.price = price;
        this.characteristic = characteristic;
    }
}
