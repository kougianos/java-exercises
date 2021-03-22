package com.javaexercices.kougianos.quiz.array;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A group of n prisoners stand in a circle awaiting execution. Starting from an arbitrary position(0),
 * the executioner kills every kth person until one person remains standing, who is then granted freedom (see examples).
 * <p>
 * Create a function that takes 2 arguments — the number of people to be executed n, and the step size k, and returns
 * the original position (index) of the person who survives.
 * <p>
 * whoGoesFree(9, 2) ➞ 2
 * // Prisoners = [0, 1, 2, 3, 4, 5, 6, 7, 8]
 * // Executed people replaced by - (a dash) for illustration purposes.
 * // 1st round of execution = [0, -, 2, -, 4, -, 6, -, 8]  -> [0, 2, 4, 6, 8]
 * // 2nd round = [-, 2, -, 6, -] -> [2, 6]  # 0 is killed in this round because it's beside 8 who was skipped over.
 * // 3rd round = [2, -]
 * <p>
 * whoGoesFree(9, 3) ➞ 0
 * // [0, 1, 2, 3, 4, 5, 6, 7, 8]
 * // [0, 1, -, 3, 4, -, 6, 7, -] -> [0, 1, 3, 4, 6, 7]
 * // [0, 1, -, 4, 6, -] -> [0, 1, 4, 6]
 * // [0, 1, -, 6] -> [0, 1, 6]
 * // [0, -, 6] -> [0, 6]
 * // [0, -] -> [0]
 */
public class Josephus {

    private Josephus() {

    }

    public static int whoGoesFree(int n, int k) {

        List<Integer> integerList = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toList());

        int startingK = k - 1;
        k--;
        while (integerList.size() > 1) {

            if (k == 1) {
                integerList.remove(1);
                Collections.rotate(integerList, -1);
                k = startingK;
                continue;
            }

            k--;
            Collections.rotate(integerList, -1);

        }

        return integerList.get(0);

    }

}
