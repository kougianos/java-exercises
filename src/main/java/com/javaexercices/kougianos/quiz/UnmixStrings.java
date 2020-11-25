package com.javaexercices.kougianos.quiz;

/**
 * Somehow my strings have all become mixed up; every pair of characters has been swapped.
 * Help me undo this so I can understand my strings again.
 * unmix("123456") ➞ "214365"
 * <p>
 * unmix("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
 * <p>
 * unmix("badce") ➞ "abcde"
 */
public class UnmixStrings {

    public static String unmix(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i+=2) {

            if (i == str.length() - 1 ) {
                sb.append(str.charAt(i));
                break;
            }

            sb.append(str.charAt(i + 1));
            sb.append(str.charAt(i));

        }

        return String.valueOf(sb);

    }


}
