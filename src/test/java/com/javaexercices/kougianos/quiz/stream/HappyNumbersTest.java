package com.javaexercices.kougianos.quiz.stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HappyNumbersTest {

    @Test
    void test1() {
        assertEquals(true, HappyNumbers.happy(100));
    }

    @Test
    void test2() {
        assertEquals(false, HappyNumbers.happy(101));
    }

    @Test
    void test3() {
        assertEquals(false, HappyNumbers.happy(102));
    }

    @Test
    void test4() {
        assertEquals(true, HappyNumbers.happy(103));
    }

    @Test
    void test5() {
        assertEquals(false, HappyNumbers.happy(104));
    }

    @Test
    void test6() {
        assertEquals(false, HappyNumbers.happy(105));
    }

    @Test
    void test7() {
        assertEquals(false, HappyNumbers.happy(106));
    }

    @Test
    void test8() {
        assertEquals(false, HappyNumbers.happy(107));
    }

    @Test
    void test9() {
        assertEquals(false, HappyNumbers.happy(108));
    }

    @Test
    void test10() {
        assertEquals(true, HappyNumbers.happy(109));
    }

    @Test
    void test11() {
        assertEquals(false, HappyNumbers.happy(110));
    }
    
}
