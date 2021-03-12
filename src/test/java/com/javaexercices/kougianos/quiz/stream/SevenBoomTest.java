package com.javaexercices.kougianos.quiz.stream;

import com.javaexercices.kougianos.quiz.stream.SevenBoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SevenBoomTest {
    @Test
    void test1() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{2, 6, 7, 9, 3}));
    }

    @Test
    void test2() {
        assertEquals("there is no 7 in the array", SevenBoom.boom(new int[]{33, 68, 400, 5}));
    }

    @Test
    void test3() {
        assertEquals("there is no 7 in the array", SevenBoom.boom(new int[]{86, 48, 100, 66}));
    }

    @Test
    void test4() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{76, 55, 44, 32}));
    }

    @Test
    void test5() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{35, 4, 9, 37}));
    }
}
