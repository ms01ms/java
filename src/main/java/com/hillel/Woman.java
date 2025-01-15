package com.hillel;

class Woman extends Person {
    public static final String GENDER = "Female";

    public Woman(String name, int age, PersonRole role) throws InvalidPersonDataException {
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
