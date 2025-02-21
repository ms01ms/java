package com.hillel.hw1_22;

public class Homework9 {

    public static void main(String[] args) {
        try {
            Person person1 = new Man("John", 30, PersonRole.ENGINEER);
            Person person2 = new Woman("", 20, PersonRole.TEACHER);
            Person person3 = new Man("Bob", 35, PersonRole.DOCTOR);

            person1.displayInformation();
            person2.displayInformation();
            person3.displayInformation();

            person2.changeProfession(PersonRole.DATA_SCIENTIST);

            System.out.println("Updated Information:");
            person2.displayInformation(true);

            System.out.println("Simplified Information:");
            person2.displayInformation(false);
        } catch (InvalidPersonDataException invalidPersonDataException) {
            invalidPersonDataException.printStackTrace();
        }
    }
}
