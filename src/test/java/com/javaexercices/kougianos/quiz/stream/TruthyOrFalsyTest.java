package com.javaexercices.kougianos.quiz.stream;

import com.javaexercices.kougianos.quiz.stream.TruthyOrFalsy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TruthyOrFalsyTest {
    @Test
    void test01() {
        assertEquals(true, TruthyOrFalsy.allTruthy(true, true, true));
    }

    @Test
    void test02() {
        assertEquals(false, TruthyOrFalsy.allTruthy(Float.NaN, Float.POSITIVE_INFINITY, null));
    }

    @Test
    void test03() {
        assertEquals(true, TruthyOrFalsy.allTruthy(Integer.MAX_VALUE));
    }

    @Test
    void test04() {
        assertEquals(true, TruthyOrFalsy.allTruthy(1,-2, 3,-4, 5.32f, 3.14151692653589793));
    }

    @Test
    void test05() {
        assertEquals(false, TruthyOrFalsy.allTruthy(false, true, true, true, 20));
    }

    @Test
    void test06() {
        assertEquals(true, TruthyOrFalsy.allTruthy(Float.MAX_EXPONENT, 92347238467.21938, "Hello World"));
    }

    @Test
    void test07() {
        assertEquals(false, TruthyOrFalsy.allTruthy(Double.NaN, 92347238467.21938, "Hello World", 0.0f));
    }

    @Test
    void test08() {
        assertEquals(true, TruthyOrFalsy.allTruthy("t", "te", "tes", "tesh", "tesha"));
    }

    @Test
    void test09() {
        assertEquals(false, TruthyOrFalsy.allTruthy(Double.NEGATIVE_INFINITY));
    }

    @Test
    void test10() {
        assertEquals(false, TruthyOrFalsy.allTruthy(true, 32, Double.POSITIVE_INFINITY, Integer.MIN_VALUE));
    }

    @Test
    void test11() {
        assertEquals(true, TruthyOrFalsy.allTruthy(true, new Integer(1), new Object[] {1,-2}, 1));
    }

    @Test
    void test12() {
        assertEquals(false, TruthyOrFalsy.allTruthy(true, 0.1f, "", true, true));
    }
}
