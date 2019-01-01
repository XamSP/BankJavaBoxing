package Bank;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();

    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }

    public void printAllBranches() {
        System.out.println("All the branches are: ");

        for (int i = 0; i < branches.size(); i++) {
            System.out.println((i + 1) + " - " + branches.get(i).getName());
        }
    }

    public void addBranch(String name) {

        if(findBranch(name) >= 0){
            System.out.println(name + " already exist!");

        } else {
            Branch newBranch = new Branch(name);
            branches.add(newBranch);
            System.out.println(name + " was added!");
        }
    }

    public int findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)){
                return i;
                //System.out.println(name + " was found!");
            }
        }

        return -1;
    }

    public void makeTransaction(String customerName, String branchName, double transactionAmount){
        int indexOfBranch = findBranch(branchName);
        if(indexOfBranch < 0){
            System.out.println(branchName + " doesn't exist!");

        } else {
            branches.get(indexOfBranch).addTransaction(customerName, transactionAmount);
        }

    }

    public void addCustomerToThatBranch(String customerName, String branchName){
        int indexOfBranch = findBranch(branchName);
        if(indexOfBranch < 0){
            System.out.println(branchName + " doesn't exist!");

        } else {
            branches.get(indexOfBranch).addCustomer(customerName);
        }

    }

    public void printAllCustomersFromABranch(String branchName) {
        int indexOfBranch = findBranch(branchName);
        if (indexOfBranch < 0) {
            System.out.println(branchName + " Not found!");
        } else {
            branches.get(indexOfBranch).printAllCustomers();
        }
    }

}
