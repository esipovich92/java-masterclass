package com.esipovich.masterclass.section7.constructors.lecture37;

/**
 * @author Artem Esipovich 25.03.2018
 */

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(100);

        account.deposit(50);
        account.withdraw(100);
        account.withdraw(100);
    }
}
