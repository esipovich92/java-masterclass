package com.esipovich.masterclass.section7.constructors.lecture38;

/**
 * @author Artem Esipovich 25.03.2018
 */

public class VipPerson {

    private String name;
    private int creditLimit;
    private String email;

    public VipPerson() {
        this.name = "Artem";
        this.creditLimit = 1000;
        this.email = "ae@gmail.com";
    }

    public VipPerson(String name, String email) {
        this(name, 500, email);
    }

    public VipPerson(String name, int creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
