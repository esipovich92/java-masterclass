package com.esipovich.masterclass.autoboxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Esipovich 05.04.2018
 */

public class Customer {

    private String name;
    private List<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Customer: " + this.name;
    }
}
