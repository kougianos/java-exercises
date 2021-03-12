package com.javaexercices.kougianos.quiz.string;
import com.javaexercices.kougianos.quiz.string.Switcharoo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SwitcharooTest {
    @Test
    void test1() {
        assertEquals(".at, dog, and mouseC", Switcharoo.flipEndChars("Cat, dog, and mouse."));
    }

    @Test
    void test2() {
        assertEquals("anna, BananA", Switcharoo.flipEndChars("Anna, Banana"));
    }

    @Test
    void test3() {
        assertEquals("][", Switcharoo.flipEndChars("[]"));
    }

    @Test
    void test4() {
        assertEquals("Incompatible.", Switcharoo.flipEndChars(""));
    }

    @Test
    void test5() {
        assertEquals("Two's a pair.", Switcharoo.flipEndChars("dfdkf49824fdfdfjhd"));
    }

    @Test
    void test6() {
        assertEquals("Two's a pair.", Switcharoo.flipEndChars("#343473847#"));
    }
}
