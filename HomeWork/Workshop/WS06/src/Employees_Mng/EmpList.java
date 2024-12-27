
package Employees_Mng;

import MyUtils.Utils;
import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EmpList {
    List<Employee> listemp = new ArrayList();
    
    public void AddFromFile(String fName) {
        try {
            File f = new File(fName);
            if(!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());
                Employee emp = new Employee(code, name, salary);
                listemp.add(emp);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) {
        if(listemp.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Employee x : listemp) {
                pw.println(x.getCode() + "," + x.getName() + "," + x.getSalary());
            }
            pw.close();
            fw.close();       
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private int find(String aCode) {
        for(int i = 0; i<listemp.size(); i++) {
            if(listemp.get(i).getCode().equals(aCode.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }
    
    public void addNewEmp() {
        String newCode, newName;
        int salary;
        System.out.println("Enter new employee details: ");
        boolean check = true;
        do {
            newCode = Utils.getStringreg("Enter Code: ", "E\\d{3}$", 
                    "Code is not null", "Code is wrong format (EXXX)!!!");
            if(find(newCode) >= 0) {
                System.out.println("Code is not Duplicate");
            } else {
                check = false;
            }
        } while(check);
        newName = Utils.getString("Enter Name: ", "Name is not null");
        salary = Utils.getInt("Enter Salary: ", 1000);
        listemp.add(new Employee(newCode.toUpperCase(), newName.toUpperCase(), salary));
        System.out.println("New employee has been added");
    }
    
    public void removeEmp () {
        String dcode;
        dcode = Utils.getStringreg("Enter the code of removed employee: ", 
                "E\\d{3}$", "Code is not null", "Code is wrong format (EXXX)!!!!");
        int pos = find(dcode);
        if(pos<0) {
            System.out.println("This code does not exist");
        } else {
            listemp.remove(listemp.get(pos));
            System.out.println("The employee: " + dcode + "has been removed");
        }
    }
    
    public void promote() {
        String code;
        code = Utils.getStringreg("Enter the code of promoted employee: ", 
                "E\\d{3}$", "Code is not null", "Code is wrong format (EXXX)!!!!");
        int pos = find(code);
        if(pos < 0) {
            System.out.println("This code does not exist");
        } else {
            int oldSalary = listemp.get(pos).getSalary();
            int newSalary;
            
            System.out.println("Old salary: " + oldSalary);
            newSalary = Utils.getInt("Enter a new Salary: ", oldSalary);
            
            listemp.get(pos).setSalary(newSalary);
            System.out.println("The employee: " + code + " has been updated.");
        }
    }
    
    public void print() {
        if(listemp.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Collections.sort(listemp);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("---------------------------------");
        for(Employee x : listemp) {
            x.print();
        }
    }
}