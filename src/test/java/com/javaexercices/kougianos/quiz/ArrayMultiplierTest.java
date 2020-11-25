package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayMultiplierTest {
    @Test
    public void test01() {
        assertArrayEquals(new Object[][]{{4,4},{5,5}}, ArrayMultiplier.multiply(new Object[]{4,5}));
    }

    @Test
    public void test02() {
        assertArrayEquals(new Object[][]{{1}}, ArrayMultiplier.multiply(new Object[]{1}));
    }

    @Test
    public void test03() {
        assertArrayEquals(new Object[][]{{"*","*","*"},{"%","%","%"},{"$","$","$"}}, ArrayMultiplier.multiply(new Object[]{"*","%","$"}));
    }

    @Test
    public void test04() {
        assertArrayEquals(new Object[][]{{"A","A","A","A","A"},{"B","B","B","B","B"},{"C","C","C","C","C"},{"D","D","D","D","D"},{"E","E","E","E","E"}}, ArrayMultiplier.multiply(new Object[]{"A","B","C","D","E"}));
    }

    @Test
    public void test05() {
        assertArrayEquals(new Object[][]{{"x","x","x"},{"y","y","y"},{"z","z","z"}}, ArrayMultiplier.multiply(new Object[]{"x","y","z"}));
    }

    @Test
    public void test06() {
        assertArrayEquals(new Object[][]{{1,1},{0,0}}, ArrayMultiplier.multiply(new Object[]{1,0}));
    }
}
