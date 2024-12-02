package com.hillel;

import java.util.Scanner;

public class Homework7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        String result = repeatEnd(str, n);
        System.out.println(result);
        System.out.println(mixString("xxxx", "There"));
        System.out.println(xyzMiddle("AxyzBBB"));
        System.out.println(zipZap("zipXzap"));
        System.out.println(xyzThere("ab.xyzxyz"));
    }

    public static String repeatEnd(String str, int n) {
        String endPart = str.substring(str.length() - n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(endPart);
        }

        return result.toString();
    }

    public static String mixString(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            result.append(str1.charAt(i));
            result.append(str2.charAt(i));
        }

        if (str1.length() > minLength) {
            result.append(str1.substring(minLength));
        }
        if (str2.length() > minLength) {
            result.append(str2.substring(minLength));
        }

        return result.toString();
    }

    public static boolean xyzMiddle(String str) {
        int len = str.length();
        String target = "xyz";

        if (len < 3) {
            return false;
        }

        int midLeft = (len - 3) / 2;
        int midRight = (len - 3) / 2 + 1;

        return str.substring(midLeft, midLeft + 3).equals(target) ||
                str.substring(midRight, midRight + 3).equals(target);
    }

    public static String zipZap(String str) {
        return str.replaceAll("z.p", "zp");
    }

    public static boolean xyzThere(String str) {
        int index = str.indexOf("xyz");

        while (index != -1) {
            if (index == 0 || str.charAt(index - 1) != '.') {
                return true;
            }
            index = str.indexOf("xyz", index + 1);
        }
        return false;
    }
}

