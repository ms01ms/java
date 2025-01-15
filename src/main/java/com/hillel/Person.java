package com.hillel;

abstract class Person implements Displayable {

    private String name;
    private int age;
    private PersonRole role;

    public Person(String name, int age, PersonRole role) throws InvalidPersonDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonDataException("Name cannot be null or empty.");
        }
        if (age < 0) {
            throw new InvalidPersonDataException("Age cannot be negative.");
        }
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPersonDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonDataException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidPersonDataException {
        if (age < 0) {
            throw new InvalidPersonDataException("Age cannot be negative.");
        }
        this.age = age;
    }

    public PersonRole getProfession() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public void changeProfession(PersonRole newRole) {
        this.role = newRole;
    }

    @Override
    public void displayInformation() {
        System.out.print("Name: " + name);
        System.out.print(" Age: " + age);
        System.out.print(" Profession: " + role);
    }

    protected abstract void displayInformation(boolean detailed);
}
