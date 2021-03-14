package com.javaexercices.kougianos.quiz.number;

/**
 * Write a function that takes coordinates of two points on a three-dimensional
 * plane and returns the length of the line segment connecting those two points.
 */
public class LineSegment {

    private LineSegment() {

    }

    public static double lineLength(int[][] arr) {

        return Math.sqrt(
                Math.pow((double) arr[1][0] - arr[0][0], 2) +
                        Math.pow(arr[1][1] - (double) arr[0][1], 2) +
                        Math.pow(arr[1][2] - (double) arr[0][2], 2)
        );

    }
}
