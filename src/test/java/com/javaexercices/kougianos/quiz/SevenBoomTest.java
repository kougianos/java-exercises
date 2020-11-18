package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SevenBoomTest {
    @Test
    public void test1() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{2, 6, 7, 9, 3}));
    }

    @Test
    public void test2() {
        assertEquals("there is no 7 in the array", SevenBoom.boom(new int[]{33, 68, 400, 5}));
    }

    @Test
    public void test3() {
        assertEquals("there is no 7 in the array", SevenBoom.boom(new int[]{86, 48, 100, 66}));
    }

    @Test
    public void test4() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{76, 55, 44, 32}));
    }

    @Test
    public void test5() {
        assertEquals("Boom!", SevenBoom.boom(new int[]{35, 4, 9, 37}));
    }
}
