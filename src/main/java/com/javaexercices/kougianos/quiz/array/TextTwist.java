package com.javaexercices.kougianos.quiz.array;

import java.util.Map;

/**
 * In Text Twist, players try to score points by forming words using the letters from a
 * 6-letter scrambled word. They win the round if they can successfully unscramble the 6-letter word.
 * <p>
 * Create a function that takes in an array of already-guessed words, the unscrambled 6
 * -letter word and returns the total number of points the player scored in a particular
 * round using the following rubric:
 * <p>
 * 3-letter words are 1 pt
 * 4-letter words are 2 pts
 * 5-letter words are 3 pts
 * 6-letter words are 4 pts + 50 pt bonus (for unscrambling the word)
 * Remember that invalid words (words that cannot be formed from the 6-letter unscrambled words) count as 0 pts.
 * <p>
 * totalPoints(["cat", "create", "sat"], "caster") ➞ 2
 * // Since "create" is an invalid word.
 * <p>
 * totalPoints(["trance", "recant"], "recant") ➞ 108
 * // Since "trance" and "recant" score 54 pts each.
 * <p>
 * totalPoints(["dote", "dotes", "toes", "set", "dot", "dots", "sted"], "tossed") ➞ 13
 * // Since 2 + 3 + 2 + 1 + 1 + 2 + 2 = 13
 */
public class TextTwist {

    private TextTwist() {

    }

    public static int totalPoints(String[] guesses, String word) {

        Map<Integer, Integer> letters2points = Map.of(
                3, 1,
                4, 2,
                5, 3,
                6, 54
        );

        int totalScore = 0;
        String mutableWord = String.valueOf(word);

        for (String guess : guesses) {
            if (guess.length() < 3 || guess.length() > 6) {
                continue;
            }

            boolean isValidGuess = true;

            for (int i = 0; i < guess.length(); i++) {

                char guessChar = guess.charAt(i);

                if (mutableWord.indexOf(guessChar) == -1) {
                    isValidGuess = false;
                    break;
                }

                mutableWord = mutableWord.replaceFirst(String.valueOf(guessChar), "");

            }

            if (isValidGuess) {
                totalScore += letters2points.get(guess.length());
            }

            mutableWord = word;

        }

        return totalScore;

    }


}
