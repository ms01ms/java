package com.hillel;

public class Homework8 {
    public static void main(String[] args) {
        catDog("");
        centeredAverage(new int[]{});
        sumIgnoreSections(new int[]{});
        sumWithoutUnlucky13(new int[]{});
        differenceLargestSmallest(new int[]{});
        doubleChars("");
        countHi("");
        countCode("");
        endsWith("", "");
        countEvenInts(new int[]{});
    }

    public static boolean catDog(String str) {
        int catCount = 0;
        int dogCount = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                catCount++;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                dogCount++;
            }
        }

        return catCount == dogCount;

    }

    public static int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        sum -= min;
        sum -= max;

        return sum / (nums.length - 2);
    }

    public static int sumIgnoreSections(int[] nums) {
        int total = 0;
        boolean isIgnoring = false;

        for (int num : nums) {
            if (num == 6) {
                isIgnoring = true;
            } else if (num == 7 && isIgnoring) {
                isIgnoring = false;
            } else if (!isIgnoring) {
                total += num;
            }
        }

        return total;
    }

    public static int sumWithoutUnlucky13(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int total = 0;
        boolean skipNext = false;

        for (int num : nums) {
            if (skipNext) {
                skipNext = false;
                continue;
            }

            if (num == 13) {
                skipNext = true;
                continue;
            }

            total += num;
        }

        return total;
    }

    public static int differenceLargestSmallest(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return max - min;
    }

    public static String doubleChars(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.append(ch);
            result.append(ch);
        }

        return result.toString();
    }

    public static int countHi(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            String substring = str.substring(i, i + 2);
            if (substring.equals("hi")) {
                count++;
            }
        }

        return count;
    }

    public static int countCode(String str) {
        int count = 0;

        for (int i = 0; i <= str.length() - 4; i++) {
            String substring = str.substring(i, i + 4);

            if (substring.charAt(0) == 'c' && substring.charAt(1) == 'o' && substring.charAt(3) == 'e') {
                count++;
            }
        }

        return count;
    }

    public static boolean endsWith(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        return str1.endsWith(str2) || str2.endsWith(str1);
    }

    public static int countEvenInts(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}



