
package FPTShop;

public class Air_conditioner extends Product {
    private int power;

    public Air_conditioner(String code, String name, String brand, int power, float price, int quantity) {
        super(code, name, brand, price, quantity);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Air_conditioner - " + 
               " Code: " + this.getCode() +
               ", Name: " + this.getName() +
               ", Brand: " + this.getBrand() +
               ", Power: " + power +
               ", Price: " + this.getPrice() +
               ", Quantity: " + this.getQuantity();
    }
}
