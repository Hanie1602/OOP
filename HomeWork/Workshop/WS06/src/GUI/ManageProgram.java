package GUI;

import Employees_Mng.*;
import java.util.Scanner;

public class ManageProgram {
    public static void main(String[] args) {
        String filename = "employees.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new employee");
        menu.add("Remove an employee");
        menu.add("Promoting a employee's salary");
        menu.add("Print the list");
        menu.add("Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        EmpList listobj = new EmpList();
        listobj.AddFromFile(filename);
        do {
            System.out.println("\nEMPLOYEE MANAGER");
            userChoice = menu.getUserChoice();
            switch(userChoice) {
                case 1:
                    listobj.addNewEmp();    changed = true;     break;
                case 2:
                    listobj.removeEmp();    changed = true;     break;
                case 3:
                    listobj.promote();      changed = true;     break;
                case 4:
                    listobj.print();        break;
                case 5:
                    listobj.saveToFile(filename);           changed = false;
                default: if (changed) {
                    System.out.println("Save changes Y/N?: ");
                    String response = sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        listobj.saveToFile(filename);
                }
            }
        } while (userChoice > 0 && userChoice < 6);
    }
}
