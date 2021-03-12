package com.javaexercices.kougianos.quiz.string;

import com.javaexercices.kougianos.quiz.string.UnmixStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnmixStringsTest {
    @Test
    void test1() {
        assertEquals("214365", UnmixStrings.unmix("123456"));
    }

    @Test
    void test2() {
        assertEquals("This is a mixed up string.", UnmixStrings.unmix("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    void test3() {
        assertEquals("abcde", UnmixStrings.unmix("badce"));
    }

    @Test
    void test4() {
        assertEquals("I am feeling a little dizzy!", UnmixStrings.unmix(" Imaf eeilgna l tilt eidzz!y"));
    }

    @Test
    void test5() {
        System.out.println("Should work with empty strings as well.");
        assertEquals("", UnmixStrings.unmix(""));
    }
}
