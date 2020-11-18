package com.javaexercices.kougianos.quiz;

import java.util.Arrays;

/**
 * Create a function that takes an array of numbers and return "Boom!"
 * if the number 7 appears in the array. Otherwise, return "there is no 7 in the array". <br>
 * <p>
 * sevenBoom([1, 2, 3, 4, 5, 6, 7]) ➞ "Boom!"<br>
 * // 7 contains the number seven.<br>
 * sevenBoom([8, 6, 33, 100]) ➞ "there is no 7 in the array"<br>
 * // None of the items contain 7 within them.<br>
 * sevenBoom([2, 55, 60, 97, 86]) ➞ "Boom!"<br>
 * // 97 contains the number seven.<br>
 */
public class SevenBoom {
    public static String boom(int[] arr) {
        return Arrays.stream(arr).boxed()
                .map(String::valueOf)
                .noneMatch(e -> e.contains("7")) ? "there is no 7 in the array" : "Boom!";
    }
}
