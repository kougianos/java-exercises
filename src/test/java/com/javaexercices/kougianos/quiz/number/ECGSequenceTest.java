package com.javaexercices.kougianos.quiz.number;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ECGSequenceTest {

    @Test
    void test1() {
        assertEquals(4, ECGSequence.ecgSequenceIndex(3));
    }

    @Test
    void test2() {
        assertEquals(9, ECGSequence.ecgSequenceIndex(5));
    }

    @Test
    void test3() {
        assertEquals(13, ECGSequence.ecgSequenceIndex(7));
    }

    @Test
    void test4() {
        assertEquals(11, ECGSequence.ecgSequenceIndex(18));
    }

    @Test
    void test5() {
        assertEquals(20, ECGSequence.ecgSequenceIndex(33));
    }

    @Test
    void test6() {
        assertEquals(40, ECGSequence.ecgSequenceIndex(44));
    }

    @Test
    void test7() {
        assertEquals(43, ECGSequence.ecgSequenceIndex(69));
    }

    @Test
    void test8() {
        assertEquals(68, ECGSequence.ecgSequenceIndex(75));
    }

    @Test
    void test9() {
        assertEquals(188, ECGSequence.ecgSequenceIndex(101));
    }

    @Test
    void test10() {
        assertEquals(199, ECGSequence.ecgSequenceIndex(208));
    }

    @Test
    void test11() {
        assertEquals(281, ECGSequence.ecgSequenceIndex(300));
    }
    
}
