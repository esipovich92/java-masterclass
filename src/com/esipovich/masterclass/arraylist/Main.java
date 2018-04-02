package com.esipovich.masterclass.arraylist;

import java.util.Scanner;

/**
 * @author Artem Esipovich 01.04.2018
 */

public class Main {
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action: (6 to show available actions)");
            int action = scanner.nextInt();

            switch (action){
                case 0:
                    System.out.println("Shutting down..");
                    quit = true;
                    break;
                case 1:
                    System.out.println("Contacts: ");
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    private static void addNewContact() {
        System.out.println("Enter contact name:");
        String name = scanner.next();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.next();
        Contact contact = Contact.createNewContact(name, phoneNumber);
        if (mobilePhone.addNewContact(contact)) {
            System.out.println("Contact " + name + " was created!");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact wasn't found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.next();
        System.out.println("Enter new contact phone number: ");
        String phoneNumber = scanner.next();
        Contact contact = Contact.createNewContact(newName, phoneNumber);
        if (mobilePhone.updateContact(existingContact, contact)) {
            System.out.println("Successfully updated!");
        } else {
            System.out.println("Wasn't updated");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact wasn't found");
            return;
        }

        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Successfully removed");
        } else {
            System.out.println("Error while deleting");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.next();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact wasn't found");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + ", phone number is: " + existingContact.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting phone..");
    }

    private static void printActions() {
        System.out.println("List of options:");
        System.out.println("0 - to shutdown" +
                           "\n1 - print contacts" +
                           "\n2 - add new contact" +
                           "\n3 - update contact" +
                           "\n4 - remove contact" +
                           "\n5 - find contact" +
                           "\n6 - list of actions\n");
    }
}
