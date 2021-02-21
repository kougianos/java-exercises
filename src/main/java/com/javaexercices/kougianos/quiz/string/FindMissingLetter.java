package com.javaexercices.kougianos.quiz.string;

/**
 * Create a function that takes an array of increasing letters and return the missing letter.
 * missingLetter(["a""b""c""e""f""g"]) ➞ "d"
 * missingLetter(["O""Q""R""S"]) ➞ "P"
 * missingLetter(["t""u""v""w""x""z"]) ➞ "y"
 * missingLetter(["m""o"]) ➞ "n"
 */
public class FindMissingLetter {

    public static String missingLetter(String[] arr) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String arrToString = String.join("", arr).toLowerCase();
        char c = arr[0].charAt(0);
        boolean lowercase = Character.isLowerCase(c);

        char firstChar = arrToString.charAt(0);

        int startIndex = alphabet.indexOf(firstChar);
        int endIndex = startIndex + arrToString.length();

        String substring = alphabet.substring(startIndex, endIndex);

        for (int i = 0; i < arrToString.length(); i++) {

            if (arrToString.charAt(i) != substring.charAt(i)) {
                return lowercase ? String.valueOf(substring.charAt(i)) :
                        String.valueOf(substring.toUpperCase().charAt(i));
            }
        }

        return "No difference";
    }
}
