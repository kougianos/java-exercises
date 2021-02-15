package com.javaexercices.kougianos.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings, s1 and s2, select only the characters in each string where the
 * character in the same position in the other string is in uppercase. Return these as a single string.
 * <p>
 * To illustrate, given the strings s1 = "heLLo" and s2 = "GUlp", we select the
 * letters "he" from s1, because "G" and "U" are uppercase. We then select "lp" from s2,
 * because "LL" is in uppercase. Finally, we join these together and return "help".
 * <p>
 * selectLetters("heLLO", "GUlp") ➞ "help"
 * selectLetters("1234567", "XxXxX")  ➞ "135"
 * selectLetters("EVERYTHING", "SomeThings") ➞  "EYSomeThings"
 */
public class CapitalChallenge {

    public static String selectLetters(String s1, String s2) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            try {
                if(Character.isUpperCase(s2.charAt(i))) {
                    sb.append(s1.charAt(i));
                }
            } catch (IndexOutOfBoundsException e) {
                // do nothing
            }
        }
        for (int i = 0; i < s1.length(); i++) {
            try {
                if(Character.isUpperCase(s1.charAt(i))) {
                    sb.append(s2.charAt(i));
                }
            } catch (IndexOutOfBoundsException e) {
                // do nothing
            }
        }

        return String.valueOf(sb);

    }

}
