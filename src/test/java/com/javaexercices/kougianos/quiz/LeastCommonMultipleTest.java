package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeastCommonMultipleTest {

    @Test
    void test1() {
        assertEquals(18, LeastCommonMultiple.lcm(9, 18));
    }

    @Test
    void test2() {
        assertEquals(40, LeastCommonMultiple.lcm(8, 5));
    }

    @Test
    void test3() {
        assertEquals(187, LeastCommonMultiple.lcm(17, 11));
    }

    @Test
    void test4() {
        assertEquals(85, LeastCommonMultiple.lcm(17, 5));
    }

    @Test
    void test5() {
        assertEquals(12, LeastCommonMultiple.lcm(3, 12));
    }

    @Test
    void test6() {
        assertEquals(9, LeastCommonMultiple.lcm(9, 9));
    }

}
