package com.javaexercices.kougianos.quiz;

import java.util.Map;

/**
 * Create a program that converts a phone number with letters to one with only numbers.
 * Number	Letter
 * 0	    none
 * 1	    none
 * 2	    ABC
 * 3	    DEF
 * 4	    GHI
 * 5	    JKL
 * 6	    MNO
 * 7	    PQRS
 * 8	    TUV
 * 9	    WXYZ
 */
public class PhoneNumberDecoder {

    public static void main(String[] args) {
        String result = textToNum("123-647-EYES");
        System.out.print(result);
    }

    public static String textToNum(String phone) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Map<String, String> mapping = Map.of(
                "ABC", "2",
                "DEF", "3",
                "GHI", "4",
                "JKL", "5",
                "MNO", "6",
                "PQRS", "7",
                "TUV", "8",
                "WXYZ", "9"
        );

        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (Character.isDigit(c) || !alphabet.contains(String.valueOf(c))) {
                continue;
            }
            String key = mapping.keySet().stream().filter(e -> e.contains(String.valueOf(c))).findFirst()
                    .orElse("");

            if (key.isEmpty()) {
                return "";
            }
            String num = mapping.get(key);
            phone = phone.replace(String.valueOf(c), num);

        }

        return phone;

    }

}
