
package Management;

import FPTShop.*;
import MyUtils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManagementApp {
    String code, name, brand, cpu;
    float price, size;
    int quantity, ram, power;
    
    ArrayList <Product> pList = new ArrayList<> ();
    
    //1.Add a new product
    public void addNewProduct () {
                
        int productType = Utils.getInt("\n1. Smartphone \n2. TV \n3. Air-conditioner \nSelect a product type to add: ", 1, 3);
        
        do {
            code = Utils.getStringreg("Enter product code (must be in format P000000): ", 
                "P\\d{6}", "Product code cannot be empty", "Invalid product code format. Please use format P000000");
            if (!Utils.isCodeUnique(code, pList)) {
                System.out.println("Product with the same code already exist. Please enter a unique code");
            }
        } while (!Utils.isCodeUnique(code, pList));
        
        name = Utils.getString("Enter product name: ", "Product name cannot be empty");
        brand = Utils.getString("Enter product brand: ", "Product brand cannot be empty");
        price = Utils.getFloat("Enter product price: ", 0);
        quantity = Utils.getIntAgain("Enter product quantity: ", 0);
        
        switch (productType) {
            case 1:
                ram = Utils.getIntAgain("Enter RAM size (in GB): ", 0);
                cpu = Utils.getString("Enter CPU model: ", "CPU cannot be empty");
                size = Utils.getFloat("Enter screen size: ", 0);
                
                Smartphone sp = new Smartphone(code, name, brand, ram, cpu, size, price, quantity);
                pList.add(sp);
                break;
                
            case 2:
                size = Utils.getFloat("Enter TV size: ", 0);
                
                TV tv = new TV(code, name, brand, size, price, quantity);
                pList.add(tv);
                break;
                
            case 3:
                power = Utils.getIntAgain("Enter power (in watts): ", 0);
                
                Air_conditioner ac = new Air_conditioner(code, name, brand, power, price, quantity);
                pList.add(ac);
                break;
           default:
               System.out.println("Invalid product type");
        }
        System.out.println("Product added successfully with code: " + code);
        
        int choice = Utils.getInt("1. Add a new product \n2. Exit \nEnter your choice (1-2): ", 1, 2);
        if(choice == 2) {
            return;
        } else {
            addNewProduct();
        }
    }
    
    //2.Print out the list of products on the screen
    public void printAllProduct() {
        System.out.println("--- LIST OF ALL PRODUCT ---");
        
        if (pList.isEmpty()) {
            System.out.println("No products available");
        }
        else {
            for (Product p : pList) {
                System.out.println(p);
            }
        }
    }
    
    //3.Print a list of Smartphones in Descending order of price
    public void printSmartphones () {
        List <Smartphone> smartphones = new ArrayList<> ();
        for (Product p : pList) {
            if (p instanceof Smartphone) {
                smartphones.add((Smartphone)p);
            }
        }
        
        if(smartphones.isEmpty()) {
            System.out.println("No Smartphones available");
        } else {
            Collections.sort(smartphones, sortDescending());
            
            System.out.println("--- SMARTPHONE LIST (Descending order of price) ---");
            for (Smartphone sm : smartphones) {
                System.out.println(sm);
            }
        }
    }
    
    private Comparator<Product> sortDescending() {
        Comparator<Product> d = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                float price1 = p1.getPrice();
                float price2 = p2.getPrice();
            
                // Compare the prices in descending order 
                if (price1 > price2) {    //Cách 2: return Float.compare(price1, price2)
                    return -1;
                } else if (price1 < price2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        return d;
    }
    
    
    //4.Print a list of Tivis in Ascending order of price
    public void printTV() {
        List <TV> tv01 = new ArrayList<> ();
        for(Product p : pList) {
            if(p instanceof TV) {
                tv01.add((TV)p);
            }
        }
        
        if(tv01.isEmpty()) {
            System.out.println("No TVs available");
        } else {
            Collections.sort(tv01, sortAscending());
            
            System.out.println("--- TV LIST (Ascendingorder of price) ---");
            for(TV t : tv01) {
                System.out.println(t);
            }
        }
    }
    
    private Comparator<Product> sortAscending() {
        Comparator<Product> ascendingComparator = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                float price1 = p1.getPrice();
                float price2 = p2.getPrice();

                // Compare the prices in ascending order
                if (price1 < price2) {
                    return -1;                      //p1 comes before p2
                } else if (price1 > price2) {
                    return 1;                       //p1 comes after p2
                } else {
                    return 0;                       //p1 and p2 have the same price
                }
            }
        };
        return ascendingComparator;
    }
    
    
    //5.Print a list of Air-conditioner in Descending order of price.
    public void printAir_conditioner () {
        List <Air_conditioner> air= new ArrayList<> ();
        for(Product p : pList) {
            if (p instanceof Air_conditioner) {
                air.add((Air_conditioner)p);
            }
        }
        
        if(air.isEmpty()){
            System.out.println("No Air-conditioner available");
        } else {
            Collections.sort(air,sortDescending());
            
            System.out.println("--- AIR-CONDITIONER LIST (Descending order of price) ---");
            for(Air_conditioner a : air) {
                System.out.println(a);
            }
        }
    }
    
    //6.Print information about products with the highest unit price for each product type
    //===============================================================================================
    //=========================================CHƯA CHỈNH SỬA==========================================
    //===============================================================================================
    public void printProductHU () {
        List <Smartphone> smartphones = new ArrayList<> ();
        List <TV> tv01 = new ArrayList<> ();
        List <Air_conditioner> air= new ArrayList<> ();
        
        for (Product p : pList) {
            if (p instanceof Smartphone) {
                smartphones.add((Smartphone)p);
            } else if (p instanceof TV) {
                tv01.add((TV)p);
            } else if(p instanceof Air_conditioner) {
                air.add((Air_conditioner)p);
            }
        }
        
        System.out.println("--- PRODUCT WITH HIGHEST UNIT PRICE ---");
        
        if (!smartphones.isEmpty()) {
            float maxSmartphonePrice = getMaxUnitPrice(smartphones);
            for(Smartphone sm : smartphones) {
                if (sm.getPrice() == maxSmartphonePrice) {
                    System.out.println(sm);
                }
            }
        }
        
        if(!tv01.isEmpty()) {
            float maxTVPrice = getMaxUnitPrice(tv01);
            for(TV t : tv01) {
                if(t.getPrice() == maxTVPrice) {
                    System.out.println(t);
                }
            }
        }
        
        if(!air.isEmpty()) {
            float maxAirPrice = getMaxUnitPrice(air);
            for(Air_conditioner a : air) {
                if (a.getPrice() == maxAirPrice) {
                    System.out.println(a);
                }
            }
        }
    }
    
    private float getMaxUnitPrice(List <? extends Product> products) {
        float maxPrice = Float.MIN_VALUE;
        for (Product p : products) {
            if (p.getPrice() > maxPrice) {
                maxPrice = p.getPrice();
            }
        }
        return maxPrice;
    }
    
    
    //===============================================================================================
    //=========================================ĐÃ CHỈNH SỬA==========================================
    //===============================================================================================
     /*public void printProductHU() {
        List<Smartphone> smartphones = filterProducts(Smartphone.class);
        List<TV> tvs = filterProducts(TV.class);
        List<Air_conditioner> airConditioners = filterProducts(Air_conditioner.class);

        System.out.println("--- PRODUCT WITH HIGHEST UNIT PRICE ---");

        printHighestPricedProduct(smartphones);
        printHighestPricedProduct(tvs);
        printHighestPricedProduct(airConditioners);
    }

    private <T extends Product> List<T> filterProducts(Class<T> productType) {
        List<T> filteredProducts = new ArrayList<>();
        for (Product p : pList) {
            if (productType.isInstance(p)) {
                filteredProducts.add(productType.cast(p));
            }
        }
        return filteredProducts;
    }

    private <T extends Product> void printHighestPricedProduct(List<T> products) {
        if (!products.isEmpty()) {
            float maxPrice = getMaxUnitPrice(products);
            for (T product : products) {
                if (product.getPrice() == maxPrice) {
                    System.out.println(product);
                }
            }
        }
    }

    private <T extends Product> float getMaxUnitPrice(List<T> products) {
        float maxPrice = Float.MIN_VALUE;
        for (Product p : products) {
            if (p.getPrice() > maxPrice) {
                maxPrice = p.getPrice();
            }
        }
        return maxPrice;
    }*/
   
    //7. Update the product  information based on the code the user entered
    public void updateProduct () {
        String newName, newBrand, newCpu;
        float newPrice, newSize;
        int newQuantity, newRam, newPower;
        
        code = Utils.getStringreg("Enter product code to update (must be in format P000000): ", 
                "P\\d{6}", "Product code cannot be empty", "Invalid product code format. Please use format P000000");
        
        for (Product p : pList) {
            if(p.getCode().equals(code)){
                System.out.println("Enter new information:");
                
                newName = Utils.getString("Enter new name: ", "Product name cannot be empty");
                if(!newName.isEmpty()) {
                    p.setName(newName);
                }
                
                newBrand = Utils.getString("Enter new brand: ", "Product brand cannot be empty ");
                if(!newBrand.isEmpty()) {
                    p.setBrand(newBrand);
                }
                
                newPrice = Utils.getFloat("Enter new price: ", 0);
                if(newPrice > 0){
                    p.setPrice(newPrice);
                }
                
                newQuantity = Utils.getIntAgain("Enter new quantity: ", 0);
                if(newQuantity > 0) {
                    p.setQuantity(newQuantity);
                }
                
                if (p instanceof Smartphone) {
                    Smartphone spp = (Smartphone) p;
                    
                    newRam = Utils.getIntAgain("Enter new RAM size (in GB): ", 0);
                    if(newRam > 0) {
                        spp.setRam(newRam);
                    }
                    
                    newCpu = Utils.getString("Enter new CPU model: ", "CPU cannot be empty");
                    if(!newCpu.isEmpty()) {
                        spp.setCpu(newCpu);
                    }
                    
                    newSize = Utils.getFloat("Enter new screen Size: ", 0);
                    if(newSize > 0){
                        spp.setSize(newSize);
                    }
                }
                
                else if (p instanceof TV) {
                    TV tvv = (TV)p;
                    
                    newSize = Utils.getFloat("Enter new TV Size: ", 0);
                    if(newSize > 0) {
                        tvv.setSize(newSize);
                    }
                }
                
                else if (p instanceof Air_conditioner){
                    Air_conditioner airc = (Air_conditioner)p;
                    
                    newPower = Utils.getIntAgain("Enter new power (in watts): ", 0);
                    if(newPower > 0) {
                        airc.setPower(newPower);
                    }
                }
                System.out.println("Product information updated successfully");
                return;
            }
        }
        System.out.println("");
        System.out.println("Product with code " + code + " not found");
    }
      
    //8.Delete an product based on the code the user entered.
    public void deleteProduct() {
        code = Utils.getStringreg("Enter product code to delete (must be in format P000000): ", 
                "P\\d{6}", "Product code cannot be empty", "Invalid product code format. Please use format P000000");
        
        for(Product p : pList) {
            if(p.getCode().equals(code)) {
                pList.remove(p);
                System.out.println("Product deleted successfully");
                return;
            }
        }
        System.out.println("Product with code " + code + " not found");
    }
    
    //9.Print the total amount of all products
    public void printTotalAmount () {
        float totalAmount = 0;
        
        for(Product p : pList) {
            totalAmount += p.getPrice() * p.getQuantity();
        }
        System.out.println("Total amount of all products: " + totalAmount);
    }
}