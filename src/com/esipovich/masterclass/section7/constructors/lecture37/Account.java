package com.esipovich.masterclass.section7.constructors.lecture37;

/**
 * @author Artem Esipovich 25.03.2018
 */

public class Account {

    private int number;
    private int balance;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    public Account() {
    }

    public Account(int number, int balance, String customerName, String customerEmail, String customerPhone) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void deposit(int depositAmount) {
        System.out.print("Balance = " + this.balance);
        this.balance += depositAmount;
        System.out.println(" New balance = " + this.balance);
    }

    public void withdraw(int withdrawAmount) {
        if (this.balance >= withdrawAmount) {
            System.out.print("Balance = " + this.balance);
            this.balance -= withdrawAmount;
            System.out.println(" New balance = " + this.balance);
        } else {
            System.out.println("Too low balance!");
        }
    }
}
