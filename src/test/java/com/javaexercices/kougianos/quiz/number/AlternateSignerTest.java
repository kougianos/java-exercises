package com.javaexercices.kougianos.quiz.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AlternateSignerTest {

    @Test
    void test1() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{3, -2, 5, -5, 2, -8}));
    }

    @Test
    void test2() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{-6, 1, -1, 4, -3}));
    }

    @Test
    void test3() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{4, 4, -2, 3, -6, 10}));
    }

    @Test
    void test4() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{34, 49, 33, 17, -47}));
    }

    @Test
    void test5() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{22}));
    }

    @Test
    void test6() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{41, 11, 37, -30, -29, 39, -45, 15, -41, 7}));
    }

    @Test
    void test7() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{3, -7, 15, 18}));
    }

    @Test
    void test8() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{40}));
    }

    @Test
    void test9() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{40, 27, -44, -13, -31}));
    }

    @Test
    void test10() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{40, 50, -7, 45, -7}));
    }

    @Test
    void test11() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{-23, -16, -9, -15, 16}));
    }

    @Test
    void test12() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{0, 0, 0, 0}));
    }

    @Test
    void test13() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{50, 28, -5, 25, -14, -2, 20, 26, -32}));
    }

    @Test
    void test14() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{24, -10}));
    }

    @Test
    void test15() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{-2, 4, 16, -15, 24, 2}));
    }

    @Test
    void test16() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{19, -12, -37, 44, -43, 44, 47}));
    }

    @Test
    void test17() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{-21, 42, -11, 27, -16, 36, 37}));
    }

    @Test
    void test18() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{30}));
    }

    @Test
    void test19() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{3, -7, 15, -18}));
    }

    @Test
    void test20() {
        assertEquals(true, AlternateSigner.alternateSign(new int[]{9, -4, 8, -16}));
    }

    @Test
    void test21() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{3, -7, 15, -18, 0}));
    }

    @Test
    void test22() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{0}));
    }

    @Test
    void test23() {
        assertEquals(false, AlternateSigner.alternateSign(new int[]{0, 2, -5, 8, -12}));
    }
    
}
