package com.hillel.hw1_22;

public class MathOperations {

    public static void main(String[] args) {
        calculateSquare(5);
        calculateCylinderVolume(3.5, 10.0);
        calculatePower(2, 3);
    }

    public static void calculateSquare(int number) {
        int squareOfNumber = number * number;
        System.out.println("The square of a number is: " + squareOfNumber);
    }

    public static double calculateCylinderVolume(double radius, double height) {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The cylinder volume is: " + volume);
        return volume;
    }

    public static int calculatePower(int a, int b) {
        int numberToPower = (int) Math.pow(a, b);
        System.out.println("The result of a^b is: " + numberToPower);
        return (int) Math.pow(a, b);
    }
}

