package com.javaexercices.kougianos.quiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PigLatinTranslationTest {
    @Test
    public void test1() {
        assertEquals("Atscay areway reatgay etspay.", PigLatinTranslation.pigLatin("Cats are great pets."));
    }

    @Test
    public void test2() {
        assertEquals("Omtay otgay away mallsay iecepay ofway iepay.", PigLatinTranslation.pigLatin("Tom got a small piece of pie."));
    }

    @Test
    public void test3() {
        assertEquals("Ehay oldtay usway away eryvay excitingway aletay.", PigLatinTranslation.pigLatin("He told us a very exciting tale."));
    }

    @Test
    public void test4() {
        assertEquals("Away iamondday isway otnay enoughway.", PigLatinTranslation.pigLatin("A diamond is not enough."));
    }

    @Test
    public void test5() {
        assertEquals("Urryhay!", PigLatinTranslation.pigLatin("Hurry!"));
    }
}
