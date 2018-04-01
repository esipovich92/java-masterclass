package com.esipovich.masterclass.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Artem Esipovich 01.04.2018
 */

public class MobilePhone {

    private Scanner scanner = new Scanner(System.in);
    private List<Contact> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<>();
    }

    public void saveContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.next();
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact " + name + " was created!");
    }

    public void updateContact() {
        System.out.println("Enter contact number:");
        int number = scanner.nextInt();
        if (number < 1 || number > contacts.size()) {
            System.out.println("No such contact!");
            return;
        }
        Contact contact = contacts.get(number);
        System.out.println("Contact " + contact.getName() + " - enter new phone:");
        String phoneNumber = scanner.next();
        contact.setPhoneNumber(phoneNumber);
        System.out.println("Contact " + contact.getName() + " phone number was changed!");
    }

    public void removeContact() {
        System.out.println("Enter contact number:");
        int number = scanner.nextInt();
        if (number < 1 || number > contacts.size()) {
            System.out.println("No such contact!");
            return;
        }
        String contactName = contacts.get(number).getName();
        contacts.remove(number);
        System.out.println("Contact " + contactName + " was removed!");
    }

    public void findContact() {
        System.out.println("Enter contact number:");
        int number = scanner.nextInt();
        if (number < 1 || number > contacts.size()) {
            System.out.println("No such contact!");
            return;
        } else {
            Contact contact = contacts.get(number);
            System.out.println("Contact " + contact.getName() + " with phone " + contact.getPhoneNumber());
        }
    }

    public void showContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void menu() {
        System.out.println("List of options:");
        System.out.println("1 - list of contacts");
        System.out.println("2 - create new contact");
        System.out.println("3 - update contact");
        System.out.println("4 - remove contact");
        System.out.println("5 - find contact");
        System.out.println("6 - quit");
        waitForCommand();
    }

    private void waitForCommand() {
        System.out.println("Enter command:");
        int command;
        while (true) {
            command = scanner.nextInt();
            if (command == 6) {
                System.exit(0);
            }
            checkCommand(command);
        }
    }

    private void checkCommand(int command) {
        switch (command) {
            case 1:
                showContacts();
                waitForCommand();
            case 2:
                saveContact();
                waitForCommand();
            case 3:
                updateContact();
                waitForCommand();
            case 4:
                removeContact();
                waitForCommand();
            case 5:
                findContact();
                waitForCommand();
            default:
                System.out.println("Wrong command!");
        }
    }
}
