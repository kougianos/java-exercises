package com.javaexercices.kougianos.quiz.number;

import com.javaexercices.kougianos.quiz.number.LineSegment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineSegmentTest {
    @Test
    void test1() {
        int[][] arr = new int[2][3];
        arr[0][0] = 15;
        arr[0][1] = 7;
        arr[0][2] = 5;
        arr[1][0] = 22;
        arr[1][1] = 11;
        arr[1][2] = 1;
        assertEquals(9.0, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test2() {
        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 1;
        arr[0][2] = 1;
        arr[1][0] = 0;
        arr[1][1] = 0;
        arr[1][2] = 0;
        assertEquals(1.73, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test3() {
        int[][] arr = new int[2][3];
        arr[0][0] = -33;
        arr[0][1] = 33;
        arr[0][2] = -33;
        arr[1][0] = 33;
        arr[1][1] = -33;
        arr[1][2] = 33;
        assertEquals(114.31, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test4() {
        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        assertEquals(5.19, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test5() {
        int[][] arr = new int[2][3];
        arr[0][0] = 719;
        arr[0][1] = 10;
        arr[0][2] = 334;
        arr[1][0] = -65;
        arr[1][1] = 1;
        arr[1][2] = 175;
        assertEquals(800.01, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test6() {
        int[][] arr = new int[2][3];
        arr[0][0] = -11;
        arr[0][1] = -12;
        arr[0][2] = 1;
        arr[1][0] = -13;
        arr[1][1] = -14;
        arr[1][2] = -15;
        assertEquals(16.24, LineSegment.lineLength(arr),0.1);
    }

    @Test
    void test7() {
        int[][] arr = new int[2][3];
        arr[0][0] = 0;
        arr[0][1] = 0;
        arr[0][2] = 0;
        arr[1][0] = 0;
        arr[1][1] = 0;
        arr[1][2] = 0;
        assertEquals(0, LineSegment.lineLength(arr),0.1);
    }
}
