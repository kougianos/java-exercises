package com.javaexercices.kougianos.quiz.stream;


/**
 * Given any number, we can create a new number by adding the sums of squares of digits of that number.
 * For example, given 203, our new number is 4 + 0 + 9 = 13. If we repeat this process, we get a sequence of numbers:
 * 203 -> 13 -> 10 -> 1 -> 1
 * <p>
 * Sometimes, like with 203, the sequence reaches (and stays at) 1. Numbers like this are called happy.
 * Not all numbers are happy. If we started with 11, the sequence would be:
 * 11 -> 2 -> 4 -> 16 -> ...
 * This sequence will never reach 1, and so the number 11 is called unhappy.
 * <p>
 * Given a positive whole number, you have to determine whether that number is happy or unhappy.
 */
public class HappyNumbers {

    private HappyNumbers() {

    }

    public static boolean happy(int num) {

        String number = String.valueOf(num);
        while (true) {
            Integer sequenceResult = number.chars()
                    .mapToObj(e -> Character.getNumericValue(e) * Character.getNumericValue(e))
                    .reduce(0, Integer::sum);

            if (sequenceResult == 1) {
                return true;
            } else if (sequenceResult == 4) {
                return false;
            }
            number = String.valueOf(sequenceResult);
        }

    }

}
