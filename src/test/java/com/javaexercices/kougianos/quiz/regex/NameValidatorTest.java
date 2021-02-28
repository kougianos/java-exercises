package com.javaexercices.kougianos.quiz.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameValidatorTest {

    @Test
    void test1() {
        assertEquals(true, NameValidator.validName("H. Wells"));
    }

    @Test
    void test2() {
        assertEquals(true, NameValidator.validName("H. G. Wells"));
    }

    @Test
    void test3() {
        assertEquals(true, NameValidator.validName("Herbert G. Wells"));
    }

    @Test
    void test4() {
        assertEquals(true, NameValidator.validName("Herbert George Wells"));
    }

    @Test
    void test5() {
        System.out.println("Name must be 2 or 3 words.");
        assertEquals(false, NameValidator.validName("Herbert"));
    }

    @Test
    void test6() {
        System.out.println("Name must be 2 or 3 words.");
        assertEquals(false, NameValidator.validName("Herbert W. G. Wells"));
    }

    @Test
    void test7() {
        System.out.println("Incorrect capitalization.");
        assertEquals(false, NameValidator.validName("h. Wells"));
    }

    @Test
    void test8() {
        System.out.println("Incorrect capitalization.");
        assertEquals(false, NameValidator.validName("herbert G. Wells"));
    }

    @Test
    void test9() {
        System.out.println("Initials must end with a dot.");
        assertEquals(false, NameValidator.validName("H Wells"));
    }

    @Test
    void test10() {
        System.out.println("Words cannot end with a dot.");
        assertEquals(false, NameValidator.validName("Herb. Wells"));
    }

    @Test
    void test11() {
        System.out.println("First name is initial but middle name is word.");
        assertEquals(false, NameValidator.validName("H. George Wells"));
    }

    @Test
    void test12() {
        System.out.println("Last name cannot be an initial.");
        assertEquals(false, NameValidator.validName("Herbert George W."));
    }

}
