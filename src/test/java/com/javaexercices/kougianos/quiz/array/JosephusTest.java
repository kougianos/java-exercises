package com.javaexercices.kougianos.quiz.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class JosephusTest {

    @Test
    void test1() {
        assertEquals(2, Josephus.whoGoesFree(9, 2));
    }

    @Test
    void test2() {
        assertEquals(0, Josephus.whoGoesFree(9, 3));
    }

    @Test
    void test3() {
        assertEquals(6, Josephus.whoGoesFree(7, 2));
    }

    @Test
    void test4() {
        assertEquals(3, Josephus.whoGoesFree(7, 3));
    }

    @Test
    void test5() {
        assertEquals(12, Josephus.whoGoesFree(15, 4));
    }

    @Test
    void test6() {
        assertEquals(1, Josephus.whoGoesFree(14, 3));
    }

    @Test
    void test7() {
        assertEquals(21, Josephus.whoGoesFree(53, 7));
    }

    @Test
    void test8() {
        assertEquals(455, Josephus.whoGoesFree(543, 21));
    }

    @Test
    void test9() {
        assertEquals(303, Josephus.whoGoesFree(673, 13));
    }
    
}
