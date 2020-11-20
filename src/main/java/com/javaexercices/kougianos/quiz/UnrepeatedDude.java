package com.javaexercices.kougianos.quiz;

/**
 * Create a function that will remove any repeated charcter(s) in a word passed to the function.
 * Not just consecutive characters, but characters repeating anywhere in the string.
 * <p>
 * unrepeated("hello") ➞ "helo"
 * unrepeated("aaaaa") ➞ "a"
 * unrepeated("WWE!!!") ➞ "WE!"
 * unrepeated("call 911") ➞ "cal 91"
 */
public class UnrepeatedDude {

    public static String unrepeated(String word) {
        final StringBuilder output = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            String character = word.substring(i, i + 1);
            if (output.indexOf(character) < 0) // if not contained
                output.append(character);
        }
        return output.toString();
    }


}
