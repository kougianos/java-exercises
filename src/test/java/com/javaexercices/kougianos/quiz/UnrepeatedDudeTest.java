package com.javaexercices.kougianos.quiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class UnrepeatedDudeTest {
    @Test
    public void test1() {
        assertEquals("helo", UnrepeatedDude.unrepeated("hello"));
    }

    @Test
    public void test2() {
        assertEquals("WE!", UnrepeatedDude.unrepeated("WWEE!!"));
    }

    @Test
    public void test3() {
        assertEquals("cal 91", UnrepeatedDude.unrepeated("call 911"));
    }

    @Test
    public void test4() {
        assertEquals("a", UnrepeatedDude.unrepeated("aaaaaa"));
    }

    @Test
    public void test5() {
        assertEquals("altwf es", UnrepeatedDude.unrepeated("altwaff test"));
    }
}
