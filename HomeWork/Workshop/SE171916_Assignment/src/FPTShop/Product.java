
package FPTShop;

public class Product {
    private String code;
    private String name;
    private String brand;
    private float price;
    private int quantity;

    public Product(String code, String name, String brand, float price, int quantity) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Code: " + code +
               ", Name: " + name +
               ", Brand: " + brand +
               ", Price: " + price +
               ", Quatity: " + quantity;
    }
}
