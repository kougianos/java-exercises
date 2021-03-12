package com.javaexercices.kougianos.quiz.string;
import com.javaexercices.kougianos.quiz.string.UnrepeatedDude;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class UnrepeatedDudeTest {
    @Test
    void test1() {
        assertEquals("helo", UnrepeatedDude.unrepeated("hello"));
    }

    @Test
    void test2() {
        assertEquals("WE!", UnrepeatedDude.unrepeated("WWEE!!"));
    }

    @Test
    void test3() {
        assertEquals("cal 91", UnrepeatedDude.unrepeated("call 911"));
    }

    @Test
    void test4() {
        assertEquals("a", UnrepeatedDude.unrepeated("aaaaaa"));
    }

    @Test
    void test5() {
        assertEquals("altwf es", UnrepeatedDude.unrepeated("altwaff test"));
    }
}
