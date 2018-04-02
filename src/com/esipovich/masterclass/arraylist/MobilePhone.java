package com.esipovich.masterclass.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Artem Esipovich 01.04.2018
 */

public class MobilePhone {

    private List<Contact> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) > 0){
            System.out.println("Contact is already in file");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " wasn't found");
            return false;
        }
        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " was removed");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " wasn't found");
            return false;
        }
        this.contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.contacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        for (Contact contact : this.contacts) {
            System.out.println("Contact: " + contact.getName() + " phone: " + contact.getPhoneNumber());
        }
    }
}
