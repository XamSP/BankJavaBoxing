package Bank;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Bank capitalOne = new Bank("Capital One");

    private static boolean power = true;

    public static void setPower(boolean power) {
        Main.power = power;
    }

    public static void printAllCustomersFromBranch() {
        Branch currentBranch = findBranchFromInput();
        if  (currentBranch == null) {
            //findBranchFromInput() print the output
        } else {
            currentBranch.printAllCustomers();
        }
    }

    public static void printAllTransactionsFromCustomer() {
//        Branch currentBranch = findBranchFromInput();
//        if  (currentBranch == null) {
//            //findBranchFromInput() print the output
//        } else {
        Customer currentCustomer = findCustomerFromInput();
            if(currentCustomer == null){
                //findCustomerFromInput() prints the output
            } else {
                currentCustomer.printAllTransactions();
            }
        }


    public static Branch findBranchFromInput() {
        System.out.println("Which Branch?");
        String name = scanner.nextLine();
        int indexOfBranch = capitalOne.findBranch(name);
        if(indexOfBranch  >= 0){
            System.out.println(capitalOne.getBranches().get(indexOfBranch).getName() + " was found");
            return capitalOne.getBranches().get(indexOfBranch);

        } else {
            System.out.println(name + " was not found!");
            return null;
        }
    }

    public static Customer findCustomerFromInput() {
        Branch currentBranch = findBranchFromInput();
        if (currentBranch == null){
            //findBranchFromInput() print the output
            return null;
        } else {
            System.out.println("Which Customer?");
            String customerName = scanner.nextLine();
            //scanner.nextLine();
            int indexOfCustomer = currentBranch.findCustomer(customerName);
            if (indexOfCustomer < 0) {
                System.out.println(customerName + " not found!");
                return null;
            } else {
                System.out.println(currentBranch.getMyCustomers().get(indexOfCustomer).getName() + " was found!");
                return currentBranch.getMyCustomers().get(indexOfCustomer);
            }
        }
    }

    public static Double findTransactionFromInput() {
        Customer currentCustomer = findCustomerFromInput();

        if(currentCustomer == null) {
            return null;
            //findCustomerFromInput() prints the output
        } else{
            System.out.println("Which Transaction?");
            double transaction = scanner.nextDouble();
            scanner.nextLine();
            double currentCustomerTransaction = currentCustomer.findTransaction(transaction);
            if(currentCustomerTransaction < 0){
                System.out.println(transaction + " not found!");
                return null;
            } else {
                System.out.println(transaction + " was found!");
                return currentCustomerTransaction;
            }
        }
    }


    public static void menu() {
        System.out.println( "0 - Shutdown\n" +
                            "1 - Print all branches\n" +
                            "2 - Print all customers from a particular branch\n" +
                            "3-  Print all transactions from a customer\n" +
                            "4 - Find a branch\n" +
                            "5 - Find a customer from a particular branch\n" +
                            "6 - Find a transaction from a customer\n" +
                            "7 - Add a branch\n" +
                            "8 - Add a customer to a particular branch\n" +
                            "9 - Make a transaction");
    }

    public static void main(String[] args) {
        while(power) {
            menu();
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting Down...");
                    setPower(false);
                    break;

                case 1:
                    capitalOne.printAllBranches();
                    break;

                case 2:
                    printAllCustomersFromBranch();
                    break;

                case 3:
                    printAllTransactionsFromCustomer();
                    break;

                case 4:
                    findBranchFromInput();
                    break;

                case 5:
                    findCustomerFromInput();
                    break;

                case 6:
                    findTransactionFromInput();
                    break;

                case 7:
                    System.out.println("Name the Branch: ");
                    String name = scanner.nextLine();
                    capitalOne.addBranch(name);
                    //addBranch prints it out
                    break;

                case 8:
                    Branch currentBranch = findBranchFromInput();
                    if(currentBranch == null) {
                        //findBranchFromInput() prints the output
                    } else {
                        System.out.println("Name the Customer: ");
                        String newName = scanner.nextLine();
                        currentBranch.addCustomer(newName);
                       // System.out.println(newName + " was added!");
                    }
                    break;

                case 9:
                    Customer currentCustomer = findCustomerFromInput();
                    if(currentCustomer == null) {
                        //findCustomerFromInput() prints the output
                    } else {
                        System.out.println("How much? ");
                        double newDouble = scanner.nextDouble();
                        currentCustomer.addTransaction(newDouble);
                        // addTransaction prints msg out
                    }
                    break;

                default:
                    //nada
                    break;
            }
        }
    }


}
