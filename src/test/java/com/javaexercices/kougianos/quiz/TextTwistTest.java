package com.javaexercices.kougianos.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextTwistTest {

    @Test
    void test1() {
        assertEquals(13, TextTwist.totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
    }

    @Test
    void test2() {
        assertEquals(12, TextTwist.totalPoints(new String[]{"dial", "tail", "lid", "tide", "date", "late", "tad"}, "detail"));
    }

    @Test
    void test3() {
        assertEquals(108, TextTwist.totalPoints(new String[]{"trance", "recant"}, "recant"));
    }

    @Test
    void test4() {
        assertEquals(121, TextTwist.totalPoints(new String[]{"bluest", "sublet", "let", "set", "belt", "belts", "bet", "bets", "sted", "but", "tule"}, "subtle"));
    }

    @Test
    void test5() {
        assertEquals(2, TextTwist.totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
    }

    @Test
    void test6() {
        assertEquals(5, TextTwist.totalPoints(new String[]{"emote", "tome", "root"}, "meteor"));
    }
}
