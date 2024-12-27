
package FPTShop;

public class TV extends Product {
    private float size;

    public TV(String code, String name, String brand, float size, float price, int quantity) {
        super(code, name, brand, price, quantity);
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TV - " + 
               " Code: " + this.getCode() +
               ", Name: " + this.getName() +
               ", Brand: " + this.getBrand() +
               ", Size: " + size +
               ", Price: " + this.getPrice() +
               ", Quantity: " + this.getQuantity();
    }
}
