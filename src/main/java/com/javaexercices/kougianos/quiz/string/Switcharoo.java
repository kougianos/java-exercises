package com.javaexercices.kougianos.quiz.string;

/**
 * Create a function that takes a string and returns a new string with its first and last characters swapped,
 * except under three conditions: <br>
 * If the length of the string is less than two, return "Incompatible.". <br>
 * If the first and last characters are the same, return "Two's a pair.". <br>
 * <p>
 * flipEndChars("Cat, dog, and mouse.") ➞ ".at, dog, and mouseC"<br>
 * flipEndChars("ada") ➞ "Two's a pair."<br>
 * flipEndChars("Ada") ➞ "adA"<br>
 * flipEndChars("z") ➞ "Incompatible."<br>
 */
public class Switcharoo {

    private Switcharoo() {

    }

    public static String flipEndChars(String s) {


        if (s.length() < 2) {
            return "Incompatible.";
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return "Two's a pair.";
        }
        return s.charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.charAt(0);

    }
}
