package com.esipovich.masterclass.threads;

/**
 * @author Artem Esipovich 19.04.2018
 */

public class Main {

//    1. Two people using joint bank account at the same time
//        1.1. One will deposit 300 usd, and then withdraw 50
//        1.2. The other deposit 203.75 and then withdraw 100
//    2. Make BankAccount thread-safe
//    3. Add methods getAccount and printAccount. Make BankAccount thread-safe again
//        answer: don't need to syncronize'
//    4. Make BankAccount thread-safe using Reentrant class
//    5. Use tryLock with a timeout value
//    6. Update the code so that status variable is tread-safe
//        answer: local variable - don't need to synchronize'
//    7.

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("12345-67", 1000);

        new Thread(() -> {
               bankAccount.deposit(300);
               bankAccount.withdraw(50);
        }).start();

        new Thread(() -> {
            bankAccount.deposit(203.75);
            bankAccount.withdraw(100);
        }).start();
    }
}
