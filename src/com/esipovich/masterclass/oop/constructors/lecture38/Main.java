package com.esipovich.masterclass.oop.constructors.lecture38;

/**
 * @author Artem Esipovich 25.03.2018
 */

public class Main {

    public static void main(String[] args) {
        VipPerson vipPerson1 = new VipPerson();
        System.out.println(vipPerson1.getCreditLimit());

        VipPerson vipPerson2 = new VipPerson("Artem", "ae@gmail.com");
        System.out.println(vipPerson2.getCreditLimit());

        VipPerson vipPerson3 = new VipPerson("Artem",1500, "ae@gmail.com");
        System.out.println(vipPerson3.getCreditLimit());

    }



}
