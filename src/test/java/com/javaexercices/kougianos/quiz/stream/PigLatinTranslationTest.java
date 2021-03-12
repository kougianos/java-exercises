package com.javaexercices.kougianos.quiz.stream;
import com.javaexercices.kougianos.quiz.stream.PigLatinTranslation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class PigLatinTranslationTest {
    @Test
    void test1() {
        assertEquals("Atscay areway reatgay etspay.", PigLatinTranslation.pigLatin("Cats are great pets."));
    }

    @Test
    void test2() {
        assertEquals("Omtay otgay away mallsay iecepay ofway iepay.", PigLatinTranslation.pigLatin("Tom got a small piece of pie."));
    }

    @Test
    void test3() {
        assertEquals("Ehay oldtay usway away eryvay excitingway aletay.", PigLatinTranslation.pigLatin("He told us a very exciting tale."));
    }

    @Test
    void test4() {
        assertEquals("Away iamondday isway otnay enoughway.", PigLatinTranslation.pigLatin("A diamond is not enough."));
    }

    @Test
    void test5() {
        assertEquals("Urryhay!", PigLatinTranslation.pigLatin("Hurry!"));
    }
}
