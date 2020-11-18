package com.javaexercices.kougianos.quiz;

/**
 * Write a function that takes three dimensions of a brick: height(a), width(b) and depth(c)
 * and returns true if this brick can fit into a hole with the width(w) and height(h).
 * <br>
 * doesBrickFit(1, 1, 1, 1, 1) ➞ true <br>
 * doesBrickFit(1, 2, 1, 1, 1) ➞ true <br>
 * doesBrickFit(1, 2, 2, 1, 1) ➞ false <br>
 */
public class Brick {

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {

        int size1 = a * b;
        int size2 = a * c;
        int size3 = b * c;
        int hole = w * h;
        int min = size1;
        if (size2 < min) {
            min = size2;
        }
        if (size3 < min) {
            min = size3;
        }
        return min <= hole;

    }

}
