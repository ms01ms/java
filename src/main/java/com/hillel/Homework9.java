package com.hillel;

public class Homework9 {

    public static void main(String[] args) {
        Person person1 = new Man("John", 30, PersonRole.ENGINEER);
        Person person2 = new Woman("Mary", 25, PersonRole.TEACHER);
        Person person3 = new Man("Bob", 35, PersonRole.DOCTOR);

        person1.displayInformation();
        person2.displayInformation();
        person3.displayInformation();

        person2.changeProfession(PersonRole.DATA_SCIENTIST);

        System.out.println("Updated Information:");
        person2.displayInformation();
    }
}
