package com.javaexercices.kougianos.quiz.number;

import com.javaexercices.kougianos.quiz.number.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistenceTest {

    @Test
    void test1() {
        assertEquals(0, Persistence.additivePersistence(5));
    }

    @Test
    void test2() {
        assertEquals(1, Persistence.additivePersistence(27));
    }

    @Test
    void test3() {
        assertEquals(2, Persistence.additivePersistence(58));
    }

    @Test
    void test4() {
        assertEquals(3, Persistence.additivePersistence(5789));
    }

    @Test
    void test5() {
        assertEquals(0, Persistence.multiplicativePersistence(7));
    }

    @Test
    void test6() {
        assertEquals(1, Persistence.multiplicativePersistence(1234567890));
    }

    @Test
    void test7() {
        assertEquals(3, Persistence.multiplicativePersistence(39));
    }

    @Test
    void test8() {
        assertEquals(6, Persistence.multiplicativePersistence(6788));
    }

}
