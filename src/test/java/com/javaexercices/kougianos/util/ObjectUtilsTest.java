package com.javaexercices.kougianos.util;

import com.javaexercices.kougianos.dto.Dog;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ObjectUtilsTest {

    @Test
    void testDoesObjectHaveNullFields() {
        Dog dog = new Dog(1L,"Max", 7, LocalDate.of(2014, 7, 2));
        assertFalse(ObjectUtils.doesObjectHaveNullFields(Dog.class, dog));
        dog.setDob(null);
        assertTrue(ObjectUtils.doesObjectHaveNullFields(Dog.class, dog));
    }

    @Test
    void testDoesDogHaveNullFields() {
        Dog dog = new Dog(2L, "max", 1, LocalDate.MIN);
        assertFalse(ObjectUtils.doesDogHaveNullFields(dog));
        dog.setDob(null);
        assertTrue(ObjectUtils.doesDogHaveNullFields(dog));
    }
}
