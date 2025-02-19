package com.hillel.hw1_22;

public class Man extends Person {
    public static final String GENDER = "Male";

    public Man(String name, int age, PersonRole role) throws InvalidPersonDataException {
        super(name, age, role);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println(" Gender: " + GENDER);
    }

    @Override
    public void displayInformation(boolean detailed) {
        if (detailed) {
            displayInformation();
        } else {
            System.out.println("Name: " + getName() + ", Gender: " + GENDER);
        }
    }
}
