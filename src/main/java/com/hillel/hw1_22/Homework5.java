package com.hillel.hw1_22;

public class Homework5 {
    public static void main(String[] args) {
        checkAge(18);
        isPerfectSquare(9);
        calculateSumUpToN(3);
        System.out.println(getGrade(5));
        System.out.println(isPrime(0));
    }

    public static void checkAge(int age) {
        if (age >= 18) {
            System.out.println("Ви доросла особа");
        } else {
            System.out.println("Ви не є дорослою особою");
        }
    }

    public static void isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        if (number == sqrt * sqrt) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void calculateSumUpToN(int n) {
        if (n <= 0) {
            System.out.println("Хибні вхідні параметри");
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            sum = sum + i;
        }

        System.out.println("→ " + sum);
    }

    public static String getGrade(int grade) {
        switch (grade) {
            case 5:
                return "Відмінно";
            case 4:
                return "Добре";
            case 3:
                return "Задовільно";
            case 2:
                return "Незадовільно";
            case 1:
                return "Погано";
            default:
                return "Неправильна оцінка";

        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}





