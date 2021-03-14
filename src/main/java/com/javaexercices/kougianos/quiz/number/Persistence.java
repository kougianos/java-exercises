package com.javaexercices.kougianos.quiz.number;

/**
 * The additive persistence of an integer, n, is the number of times you have to replace n
 * with the sum of its digits until n becomes a single digit integer.
 * <p>
 * The multiplicative persistence of an integer, n, is the number of times you have to replace
 * n with the product of its digits until n becomes a single digit integer.
 * <p>
 * Create two functions that take an integer as an argument and:
 * <p>
 * Return its additive persistence.
 * Return its multiplicative persistence.
 * <p>
 * additivePersistence(1679583) ➞ 3
 * // 1 + 6 + 7 + 9 + 5 + 8 + 3 = 39
 * // 3 + 9 = 12
 * // 1 + 2 = 3
 * // It takes 3 iterations to reach a single-digit number.
 * <p>
 * multiplicativePersistence(77) ➞ 4
 * // 7 x 7 = 49
 * // 4 x 9 = 36
 * // 3 x 6 = 18
 * // 1 x 8 = 8
 * // It takes 4 iterations to reach a single-digit number.
 */
public class Persistence {

    private Persistence() {

    }

    public static int additivePersistence(int n) {

        String number = String.valueOf(n);
        if (number.length() == 1) {
            return 0;
        }
        int sum = 0;
        int steps = 0;
        while (true) {
            for (int i = 0; i < number.length(); i++) {
                sum += Character.getNumericValue(number.charAt(i));
            }
            steps++;
            if (String.valueOf(sum).length() > 1) {
                number = String.valueOf(sum);
                sum = 0;
            } else {
                break;
            }
        }

        return steps;

    }

    public static long multiplicativePersistence(long n) {

        String number = String.valueOf(n);
        if (number.length() == 1) {
            return 0;
        }
        int sum = 1;
        int steps = 0;
        while (true) {
            for (int i = 0; i < number.length(); i++) {
                sum *= Character.getNumericValue(number.charAt(i));
            }
            steps++;
            if (String.valueOf(sum).length() > 1) {
                number = String.valueOf(sum);
                sum = 1;
            } else {
                break;
            }
        }

        return steps;

    }

}
