package com.hillel;

public class Homework9 {

    public static void main(String[] args) {
        Person person1 = new Person("John", 30, "Engineer");
        Person person2 = new Person("Mary", 25, "Teacher");
        Person person3 = new Person("Bob", 35, "Doctor");

        System.out.println("Person info:");
        person1.showPersonInfo();
        System.out.println();
        person2.showPersonInfo();
        System.out.println();
        person3.showPersonInfo();
        System.out.println();
        System.out.println("Bob's profession update:");
        person3.setProfession("Designer");
        person3.showPersonInfo();
    }
}
