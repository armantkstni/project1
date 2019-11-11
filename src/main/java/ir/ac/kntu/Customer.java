package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

public class Customer {
    private String name;
    private int id;
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void addcustomer(){
        System.out.println("enter the customer name:");
        String Transmittername = ScannerWrapper.getInstance().next();
        System.out.println("enter the id:");
        int Transmitterid = ScannerWrapper.getInstance().nextInt();
        Customer customer = new Customer(Transmittername,Transmitterid);
        if (customers.contains(customer)){
            System.out.println("customer already exist!");
            return;
        }
        customers.add(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
    public static Customer searchCustomer(int id){
        for (int i = 0; i <customers.size() ; i++) {
            if(customers.get(i).getId()==id){
                return customers.get(i);
            }
        }
        return null;
    }
    public static void printCustomers(){
        if(customers.isEmpty())
            System.out.println("customers is empty!");
        else {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i));
            }
        }

    }
    public static void editCustomer(){
        System.out.println("enter old id:");
        int id1 = ScannerWrapper.getInstance().nextInt();
        System.out.println("enter new id:");
        int id2 = ScannerWrapper.getInstance().nextInt();
        searchCustomer(id1).setId(id2);
    }
}
