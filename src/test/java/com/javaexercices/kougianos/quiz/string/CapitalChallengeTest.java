package com.javaexercices.kougianos.quiz.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalChallengeTest {
    @Test
    void test1() {
        assertEquals("help", CapitalChallenge.selectLetters("heLLO", "GUlp"));
    }

    @Test
    void test2() {
        assertEquals("135", CapitalChallenge.selectLetters("1234567", "XxXxX"));
    }

    @Test
    void test3() {
        assertEquals("EYSomeThings", CapitalChallenge.selectLetters("EVERYTHING", "SomeThings"));
    }

    @Test
    void test4() {
        assertEquals("atrpten", CapitalChallenge.selectLetters("PaTtErN", "pAtTeRn"));
    }

    @Test
    void test5() {
        assertEquals("", CapitalChallenge.selectLetters("nothing", "nothing"));
    }

    @Test
    void test6() {
        assertEquals("What doR", CapitalChallenge.selectLetters("What do you think of it so far?", "RUBBISH!"));
    }
}
    
