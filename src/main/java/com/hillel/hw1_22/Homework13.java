package com.hillel.hw1_22;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;

public class Homework13 {

    public static void main(String[] args) {

        System.out.println(getLengthOfStrings(new String[]{"a", "bb", "a", "bb"}));
        System.out.println(createMap(new String[]{"code", "bug"}));
        System.out.println(countWords(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(mergeStringsByFirstChar(new String[]{"salt", "tea", "soda", "toast"}));
        System.out.println(buildResultString(new String[]{"a", "b", "a"}));
        int[] arr = {1, 1, 1, 2, 1, 2, 1, 2, 1};
        System.out.println(findMostFrequentElement(arr));

//      ДЗ 13.7. Перевірка на перетин множин
        LinkedHashSet<Integer> A = new LinkedHashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);

        LinkedHashSet<Integer> B = new LinkedHashSet<>();
        B.add(6);
        B.add(5);
        B.add(6);

        boolean hasIntersection = hasIntersection(A, B);

        System.out.println(hasIntersection);

//      ДЗ 13.8. Об'єднання двох множин
        TreeSet<Integer> C = new TreeSet<>();
        C.add(1);
        C.add(2);
        C.add(3);

        TreeSet<Integer> D = new TreeSet<>();
        D.add(3);
        D.add(4);
        D.add(5);

        TreeSet<Integer> E = new TreeSet<>(C);
        E.addAll(D);

        System.out.println(E);

    }

//    ДЗ 13.1. Визначення довжини рядка
    public static Map<String, Integer> getLengthOfStrings(String[] strings) {
        Map<String, Integer> result = new HashMap<>();

        for (String str : strings) {
            result.put(str, str.length());
        }

        return result;
    }

//    ДЗ 13.2. Масив в Map
    public static Map<String, String> createMap(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String str : strings) {
            if (!str.isEmpty()) {
                String key = String.valueOf(str.charAt(0));
                String value = String.valueOf(str.charAt(str.length() - 1));
                result.put(key, value);
            }
        }

        return result;
    }

//    ДЗ 13.3. Підрахунок слів
    public static Map<String, Integer> countWords(String[] strings) {
        Map<String, Integer> result = new HashMap<>();

        for (String str : strings) {
            result.put(str, result.getOrDefault(str, 0) + 1);
        }

        return result;
    }

//    ДЗ 13.4. Акцентуємося на роботу зі значеннями
    public static Map<String, String> mergeStringsByFirstChar(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String str : strings) {
            if (!str.isEmpty()) {
                String key = String.valueOf(str.charAt(0));
                result.put(key, result.getOrDefault(key, "") + str);
            }
        }

        return result;
    }

//    ДЗ 13.5. Парні рядки
    public static String buildResultString(String[] arr) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
            if (frequencyMap.get(s) % 2 == 0) {
                if (result.indexOf(s) == -1) {
                    result.append(s);
                }
            }
        }

        return result.length() > 0 ? result.toString() : "";
    }

//    ДЗ 13.6. Повернути елемент, який зустрічається найчастіше
    public static int findMostFrequentElement(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int mostFrequent = arr[0];
        int maxFrequency = 0;

        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) > maxFrequency) {
                maxFrequency = frequencyMap.get(num);
                mostFrequent = num;
            }
        }

        return mostFrequent;
    }

//    ДЗ 13.7. Перевірка на перетин множин
    public static boolean hasIntersection(LinkedHashSet<Integer> A, LinkedHashSet<Integer> B) {
        LinkedHashSet<Integer> copyA = new LinkedHashSet<>(A);
        copyA.retainAll(B);
        return !copyA.isEmpty();
    }
}

