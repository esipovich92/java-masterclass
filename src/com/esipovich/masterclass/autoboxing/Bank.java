package com.esipovich.masterclass.autoboxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 05.04.2018
 */

public class Bank {

    private String name;
    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : this.branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customers for branch " + branch.getName());
            List<Customer> customers = branch.getCustomers();
            for (Customer customer : customers) {
                System.out.println(customer.toString());
                if (showTransactions) {
                    for (double transaction : customer.getTransactions()) {
                        System.out.println(transaction + " | ");
                    }
                }
            }
            return true;
        }
        return false;
    }
}
