package com.javaexercices.kougianos.util;

import com.javaexercices.kougianos.dto.Dog;

import java.util.Objects;
import java.util.stream.Stream;

public class ObjectUtils {

    private ObjectUtils() {

    }

    /**
     * Returns true if at least one of input object's fields is null.
     * WARNING: This method uses reflection and it violates the encapsulation principle.
     * Furthermore, using reflection may cause a performance penalty in the application.
     * This function should ONLY be used if there are no alternatives, but it supports any object as input.
     *
     * @param objectClass The .class object. Eg Dog.class
     * @param object      The object itself. Eg new Dog()
     * @return boolean
     */
    public static boolean doesObjectHaveNullFields(Class<?> objectClass, Object object) {
        return Stream.of(objectClass.getDeclaredFields())
                .anyMatch(f -> {
                    f.setAccessible(true);
                    try {
                        return f.get(object) == null;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                });
    }

    /**
     * Returns true if at least one of Dog's fields is null.
     * This function can be used as a reference when the input object only has a few fields, and can be checked one by
     * one. It requires the invocation of all getters of the input object, but it does not use reflection and is much
     * faster in performance.
     *
     * @param dog input object
     * @return boolean
     */
    public static boolean doesDogHaveNullFields(Dog dog) {
        return Stream.of(dog.getName(), dog.getAgeInYears(), dog.getDob())
                .anyMatch(Objects::isNull);
    }
}
