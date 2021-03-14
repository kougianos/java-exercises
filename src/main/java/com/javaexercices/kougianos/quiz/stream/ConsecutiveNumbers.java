package com.javaexercices.kougianos.quiz.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a function that determines whether elements in an array can be re-arranged
 * to form a consecutive list of numbers where each number appears exactly once.
 * <p>
 * cons([5, 1, 4, 3, 2]) ➞ true
 * // Can be re-arranged to form [1, 2, 3, 4, 5]
 * <p>
 * cons([5, 1, 4, 3, 2, 8]) ➞ false
 * <p>
 * cons([5, 6, 7, 8, 9, 9]) ➞ false
 * // 9 appears twice
 */
public class ConsecutiveNumbers {

    private ConsecutiveNumbers() {

    }

    public static boolean cons(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                break;
            }
            if (list.get(i) + 1 != list.get(i + 1)) {
                return false;
            }
        }

        return true;

    }

}
