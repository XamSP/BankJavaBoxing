package Bank;

import java.util.ArrayList;

public class Branch {

    private String name;

    private ArrayList<Customer> myCustomers = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getMyCustomers() {
        return myCustomers;
    }

    public void printAllCustomers() {
        System.out.println("All the customers are: ");

        for (int i = 0; i < myCustomers.size(); i++) {
            System.out.println((i + 1) + " - " + myCustomers.get(i).getName());
        }
    }

    public void addTransaction(String name, double amount) {
        int indexOfCustomer = findCustomer(name);

        if (indexOfCustomer >= 0){
            Customer currentCustomer = myCustomers.get(indexOfCustomer);
            currentCustomer.addTransaction(amount);

        } else {
            Customer newlyAddedCustomer = addCustomerWithoutFind(name); //help save memory
            newlyAddedCustomer.addTransaction(amount);
        }

        System.out.println("The transaction of " + amount + " was successfully made!");
    }

    public Customer addCustomer(String name) {

        if (findCustomer(name) >= 0) {
            System.out.println(name + " already is in the system!");
            return null;

        } else {
            System.out.println(name + " is added into the system!");
            Customer customer = new Customer(name);
            myCustomers.add(customer);
            return customer;
        }
    }

    private Customer addCustomerWithoutFind(String name) {

            System.out.println(name + " is added into the system!");
            Customer customer = new Customer(name);
            myCustomers.add(customer);
            return customer;

    }

    public int findCustomer(String name) {
        for (int i = 0; i < myCustomers.size(); i++){
            if(myCustomers.get(i).getName().equals(name)){
                return i;
            }
        }

        return -1;
    }
}
