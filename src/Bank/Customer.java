package Bank;

import java.util.ArrayList;

public class Customer {

    private String name;

    //private double accountNumber;

    //private String branch;

    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name/*, double accountNumber, String branch*/) {
        this.name = name;
        //this.accountNumber = accountNumber;
        //this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        if(amount < 0){
            System.out.println(amount + " is an invalid amount!");
        }
        transactions.add(amount);
        System.out.println(amount + " transaction has been completed!");
    }

    public void printAllTransactions() {
        System.out.println("Here are all your transactions: ");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i+1) + " - " + transactions.get(i));
        }
    }

    public double findTransaction(double amount) {
        for(int i = 0; i < transactions.size(); i++){
            Double currentTransaction = transactions.get(i);
            if(currentTransaction.equals(amount)){
                return transactions.get(i);
            }
        }

        return -1;
    }
}
