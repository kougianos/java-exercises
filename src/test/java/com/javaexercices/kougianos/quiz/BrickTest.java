package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BrickTest {

    @Test
    public void test1() {
        assertEquals(true, Brick.doesBrickFit(1,1,1, 1,1));
    }

    @Test
    public void test2() {
        assertEquals(true, Brick.doesBrickFit(1,2,1, 1,1));
    }

    @Test
    public void test3() {
        assertEquals(false, Brick.doesBrickFit(1,2,2, 1,1));
    }

    @Test
    public void test4() {
        assertEquals(true, Brick.doesBrickFit(1,2,2, 1,2));
    }

    @Test
    public void test5() {
        assertEquals(true, Brick.doesBrickFit(1,2,2, 2,1));
    }

    @Test
    public void test6() {
        assertEquals(false, Brick.doesBrickFit(2,2,2, 1,2));
    }
}
