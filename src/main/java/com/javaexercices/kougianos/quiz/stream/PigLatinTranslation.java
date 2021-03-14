package com.javaexercices.kougianos.quiz.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a function that takes a string of words and moves the first letter of each word to the end of it,
 * then adds "ay" to the end of the word. This is called "Pig Latin" and it gets more complicated
 * than the rules in this particular challenge. I've intentionally kept things simple, otherwise
 * this would turn into an extremely tedious challenge.
 * <p>
 * Move the first letter of each word to the end of the word.
 * Add "ay" to the end of the word.
 * Words starting with a vowel (A, E, I, O, U) simply have "WAY" appended to the end.
 */
public class PigLatinTranslation {

    private PigLatinTranslation() {

    }

    public static String pigLatin(String str) {

        List<String> words = Arrays.asList(str.split(" "));
        List<String> vowels = Arrays.asList("A", "E", "I", "O", "U", "a", "e", "i", "o", "u");

        words = words.stream()
                .map(word -> {
                    boolean endsWithSymbol = false;
                    String symbol = "";
                    if (!Character.isLetter(word.charAt(word.length() - 1))) {
                        symbol = String.valueOf(word.charAt(word.length() - 1));
                        word = word.substring(0, word.length() - 1);
                        endsWithSymbol = true;
                    }
                    if (vowels.contains(String.valueOf(word.charAt(0)))) {
                        return endsWithSymbol ? word + "way" + symbol : word + "way";
                    }
                    if (word.length() < 2) {
                        return word;
                    }
                    word = (word.substring(1) + word.charAt(0) + "ay").toLowerCase();
                    return endsWithSymbol ? word + symbol : word;
                })
                .collect(Collectors.toList());

        words.set(0, words.get(0).substring(0, 1).toUpperCase() + words.get(0).substring(1));

        return String.join(" ", words);

    }

}
