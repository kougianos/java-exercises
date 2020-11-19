package com.javaexercices.kougianos.quiz;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Write a function that returns true if all parameters are truthy, and false otherwise.<br>
 * allTruthy("t", "te", "tes", "tesh", "tesha") ➞ true<br>
 * allTruthy(true, true, true) ➞ true<br>
 * allTruthy(true, false, true) ➞ false<br>
 * allTruthy(5, 4, 3, 2, 1, 0) ➞ false<br>
 * Falsy values include false, 0, "" (empty string), null, POSITIVE_INFINITY, NEGATIVE_INFINITY and NaN,
 * everything else is truthy.
 */
public class TruthyOrFalsy {

    public static boolean allTruthy(Object... values) {

        if (values.length == 0) {
            return false;
        }
        if (Arrays.stream(values).anyMatch(Objects::isNull)) {
            return false;
        }
        List<Object> falsies = List.of(false, "", 0, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY,
                Float.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN);

        List<Object> list =
                Arrays.stream(values).filter(falsies::contains).collect(Collectors.toList());

        return list.isEmpty();

    }

}
