package com.hillel;

public class Man extends Person {
    public static final String GENDER = "Male";

    public Man(String name, int age, PersonRole role) {
        super(name, age, role);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Gender: " + GENDER);
    }
}
