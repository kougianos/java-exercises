package com.javaexercices.kougianos.quiz.number;

/**
 * Create a function which validates whether a given array alternates between positive and negative numbers.
 * <p>
 * alternateSign([3, -2, 5, -5, 2, -8]) ➞ true
 * alternateSign([-6, 1, -1, 4, -3]) ➞ true
 * alternateSign([4, 4, -2, 3, -6, 10]) ➞ false
 */
public class AlternateSigner {

    public static boolean alternateSign(int[] arr) {

        if (arr.length == 0 || arr[0] == 0) {
            return false;
        }

        boolean nextNumberShouldBePositive = (arr[0] < 0);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == 0) {
                return false;
            }

            if (nextNumberShouldBePositive) {
                if (arr[i] < 0) {
                    return false;
                }
            } else {
                if (arr[i] > 0) {
                    return false;
                }
            }

            nextNumberShouldBePositive = !nextNumberShouldBePositive;

        }

        return true;

    }

}
