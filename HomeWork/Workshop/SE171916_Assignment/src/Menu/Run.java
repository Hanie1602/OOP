
package Menu;

import MyUtils.Utils;
import Management.ProductManagementApp;

public class Run {
    public static void main(String[] args) {
        ProductManagementApp pma = new ProductManagementApp();
        int choice;
    
    do {
        System.out.println("--- PRODUCT MANAGEMENT APPLICATION ---");
        System.out.println("1. Add a new product");
        System.out.println("2. Print all products");
        System.out.println("3. Print a list of Smartphones in descending order of price");
        System.out.println("4. Print a list of Tivis in Ascending order of price");
        System.out.println("5. Print a list of Air-conditioner  in descending order of price");
        System.out.println("6. Print information about products with the highest unit price for each product type");
        System.out.println("7. Update the product  information based on the code the user entered");
        System.out.println("8. Delete an product based on the code the user entered");
        System.out.println("9. Print the total amount of all products");
        System.out.println("10. Exit");
        choice = Utils.getIntAgain("Enter your choice: ", 0);
            
        switch (choice) {
            case 1:
                pma.addNewProduct();
                break;
            case 2:
                pma.printAllProduct();
                break;
            case 3:
                pma.printSmartphones();
                break;
            case 4:
                pma.printTV();
                break;
            case 5:
                pma.printAir_conditioner();
                break;
            case 6:
                pma.printProductHU();
                break;
            case 7:
                pma.updateProduct();
                break;
            case 8:
                pma.deleteProduct();
                break;
            case 9:
                pma.printTotalAmount();
                break;
            case 10:
                System.out.println("Thank you for using the application. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        System.out.println("");
        } while (choice != 10);
    }   
}