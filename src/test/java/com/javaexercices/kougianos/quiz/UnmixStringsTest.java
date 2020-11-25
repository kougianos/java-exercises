package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnmixStringsTest {
    @Test
    public void test1() {
        assertEquals("214365", UnmixStrings.unmix("123456"));
    }

    @Test
    public void test2() {
        assertEquals("This is a mixed up string.", UnmixStrings.unmix("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    public void test3() {
        assertEquals("abcde", UnmixStrings.unmix("badce"));
    }

    @Test
    public void test4() {
        assertEquals("I am feeling a little dizzy!", UnmixStrings.unmix(" Imaf eeilgna l tilt eidzz!y"));
    }

    @Test
    public void test5() {
        System.out.println("Should work with empty strings as well.");
        assertEquals("", UnmixStrings.unmix(""));
    }
}
