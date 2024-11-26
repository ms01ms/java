package com.hillel;

public class Homework6 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println(calculateAverage(numbers));
        System.out.println(calculateMax(numbers));
        System.out.println(calculateMin(numbers));
        System.out.println(printReverse(numbers));
        isNumberInArray(numbers);
    }

    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int number = 0; number < numbers.length; number++) {
            sum += numbers[number];
        }
        double avg = sum / numbers.length;
        return avg;
    }

    public static double calculateMax(int[] numbers) {
        int max = 0;
        for (int number = 0; number < numbers.length; number++) {
            if (numbers[number] > max) {
                max = numbers[number];
            }
        }
        return max;
    }

    public static double calculateMin(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static String printReverse(int[] numbers) {
        String result = "";
        for (int i = numbers.length - 1; i >= 0; i--) {
            result += numbers[i] + " ";
        }
        return result;
    }

    public static void isNumberInArray(int[] numbers) {
        int numberToFind = 10;
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numberToFind == numbers[i]) {
                found = true;
            }
        }
        if (found) {
            System.out.println("Number " + numberToFind + " in array");
        } else {
            System.out.println("Number " + numberToFind + " not in array");
        }
    }
}
