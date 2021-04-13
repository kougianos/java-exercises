package com.javaexercices.kougianos.util;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathUtils {

    private MathUtils() {

    }

    /**
     * Find all factors of a given number and return them in a Set or List (in ascending order).
     * Use the function with returnListFlag true for List returned.
     *
     * @param num            int        Input number.
     * @param returnListFlag boolean    When true, return list instead of set.
     * @return Collection<Integer>
     */
    public static Collection<Integer> findFactors(int num, boolean returnListFlag) {

        Collection<Integer> factors = returnListFlag ? new ArrayList<>() : new HashSet<>();

        // Skip two if the number is odd
        int incrementer = num % 2 == 0 ? 1 : 2;

        for (int i = 1; i <= Math.sqrt(num); i += incrementer) {

            // If there is no remainder, then the number is a factor.
            if (num % i == 0) {
                factors.add(i);

                // Skip duplicates
                if (i != num / i) {
                    factors.add(num / i);
                }

            }
        }

        // Sort the list of factors, in case of returned list
        if (returnListFlag) {
            Collections.sort((List<Integer>) factors);
        }

        return factors;

    }

    /**
     * Method overloading, findFactors function with default value returnListFlag = false, if omitted.
     *
     * @param num int
     * @return Set<Integer>
     */
    public static Set<Integer> findFactors(int num) {
        return (Set<Integer>) findFactors(num, false);
    }

    /**
     * Return the least common multiple of 2 numbers.
     *
     * @param number1 int
     * @param number2 int
     * @return int
     */
    public static int leastCommonMultiple(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    /**
     * Checks whether a given number is prime or not, using lambda expression.
     * A prime number is a number that is divisible only by itself and 1 (e.g. 2, 3, 5, 7, 11).
     * The function is optimized to look only until number's square root, and skips numbers that are multiples of 2.
     *
     * @param number int
     * @return boolean
     */
    public static boolean isPrime(int number) {
        return Stream.concat(Stream.of(2), IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(e -> e % 2 != 0)
                .boxed())
                .noneMatch(n -> number % n == 0);
    }

}
