package com.hillel;

public class Person {

    private String name;
    private int age;
    private String profession;

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void showPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Profession: " + profession);
    }
}
