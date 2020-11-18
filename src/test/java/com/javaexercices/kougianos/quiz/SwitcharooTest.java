package com.javaexercices.kougianos.quiz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SwitcharooTest {
    @Test
    public void test1() {
        assertEquals(".at, dog, and mouseC", Switcharoo.flipEndChars("Cat, dog, and mouse."));
    }

    @Test
    public void test2() {
        assertEquals("anna, BananA", Switcharoo.flipEndChars("Anna, Banana"));
    }

    @Test
    public void test3() {
        assertEquals("][", Switcharoo.flipEndChars("[]"));
    }

    @Test
    public void test4() {
        assertEquals("Incompatible.", Switcharoo.flipEndChars(""));
    }

    @Test
    public void test5() {
        assertEquals("Two's a pair.", Switcharoo.flipEndChars("dfdkf49824fdfdfjhd"));
    }

    @Test
    public void test6() {
        assertEquals("Two's a pair.", Switcharoo.flipEndChars("#343473847#"));
    }
}
