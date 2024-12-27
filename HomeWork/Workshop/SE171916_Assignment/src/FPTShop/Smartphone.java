
package FPTShop;

public class Smartphone extends Product {
    private int ram;
    private String cpu;
    private float size;

    public Smartphone(String code, String name, String brand, int ram, String cpu, float size, float price, int quantity) {
        super(code, name, brand, price, quantity);
        this.ram = ram;
        this.cpu = cpu;
        this.size = size;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Smartphone - " + 
               " Code: " + this.getCode() +
               ", Name: " + this.getName() +
               ", Brand: " + this.getBrand() +
               ", RAM: " + ram +
               ", CPU: " + cpu +
               ", Size: " + size +
               ", Price: " + this.getPrice() +
               ", Quantity: " + this.getQuantity();
    }
}
