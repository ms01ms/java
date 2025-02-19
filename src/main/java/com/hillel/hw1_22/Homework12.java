package com.hillel.hw1_22;

import java.util.*;

public class Homework12 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(14);
        numbers.add(15);
        numbers.add(92);
        numbers.add(6);
        System.out.println("Collection of numbers: " + numbers);

        List<String> fullName = List.of("First Name", "Last Name", "Middle Name");
        System.out.println("Collection of first name, last name, and middle name: " + fullName);

        Set<Integer> uniqueNumbers = new TreeSet<>(Arrays.asList(2, 1, 2, 3, 5, 4, 4));
        System.out.println("Set of unique numbers: " + uniqueNumbers);

        Map<String, String> cityPhoneCodes = new TreeMap<>();
        cityPhoneCodes.put("Kyiv", "044");
        cityPhoneCodes.put("Kharkiv", "057");
        cityPhoneCodes.put("Lviv", "032");
        cityPhoneCodes.put("Odesa", "048");
        cityPhoneCodes.put("Dnipro", "056");
        cityPhoneCodes.put("Zaporizhzhia", "061");
        cityPhoneCodes.put("Vinnytsia", "0432");
        cityPhoneCodes.put("Cherkasy", "0472");
        cityPhoneCodes.put("Poltava", "0532");
        cityPhoneCodes.put("Chernivtsi", "0372");
        cityPhoneCodes.put("Khmelnytskyi", "0382");
        cityPhoneCodes.put("Ivano-Frankivsk", "0342");
        cityPhoneCodes.put("Rivne", "0362");
        cityPhoneCodes.put("Ternopil", "0352");
        cityPhoneCodes.put("Zhytomyr", "0412");
        cityPhoneCodes.put("Kropyvnytskyi", "0522");
        cityPhoneCodes.put("Sumy", "0542");
        cityPhoneCodes.put("Uzhhorod", "0312");
        cityPhoneCodes.put("Mykolaiv", "0512");
        cityPhoneCodes.put("Kherson", "0552");
        cityPhoneCodes.put("Chernihiv", "0462");
        cityPhoneCodes.put("Luhansk", "0642");
        cityPhoneCodes.put("Donetsk", "062");

        System.out.println("Map of Ukrainian cities and their phone codes:");
        for (Map.Entry<String, String> entry : cityPhoneCodes.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}


