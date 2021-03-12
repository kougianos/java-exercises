package com.javaexercices.kougianos.quiz.array;

import com.javaexercices.kougianos.quiz.array.ArrayMultiplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayMultiplierTest {
    @Test
    void test01() {
        assertArrayEquals(new Object[][]{{4,4},{5,5}}, ArrayMultiplier.multiply(new Object[]{4,5}));
    }

    @Test
    void test02() {
        assertArrayEquals(new Object[][]{{1}}, ArrayMultiplier.multiply(new Object[]{1}));
    }

    @Test
    void test03() {
        assertArrayEquals(new Object[][]{{"*","*","*"},{"%","%","%"},{"$","$","$"}}, ArrayMultiplier.multiply(new Object[]{"*","%","$"}));
    }

    @Test
    void test04() {
        assertArrayEquals(new Object[][]{{"A","A","A","A","A"},{"B","B","B","B","B"},{"C","C","C","C","C"},{"D","D","D","D","D"},{"E","E","E","E","E"}}, ArrayMultiplier.multiply(new Object[]{"A","B","C","D","E"}));
    }

    @Test
    void test05() {
        assertArrayEquals(new Object[][]{{"x","x","x"},{"y","y","y"},{"z","z","z"}}, ArrayMultiplier.multiply(new Object[]{"x","y","z"}));
    }

    @Test
    void test06() {
        assertArrayEquals(new Object[][]{{1,1},{0,0}}, ArrayMultiplier.multiply(new Object[]{1,0}));
    }
}
