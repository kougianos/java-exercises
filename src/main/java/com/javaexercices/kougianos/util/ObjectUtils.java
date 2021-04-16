package com.javaexercices.kougianos.util;

import java.util.stream.Stream;

public class ObjectUtils {

    private ObjectUtils() {

    }

    /**
     * Returns true if at least one of input object's fields is null.
     * WARNING: This method uses reflection and it violates the encapsulation principle.
     * Furthermore, using reflection may cause a performance penalty in the application.
     * This function should ONLY be used if there are no alternatives, use with caution!
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
}
