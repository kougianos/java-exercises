package com.javaexercices.kougianos.quiz.array;

public class ArrayMultiplier {

    public static Object[][] multiply(Object[] items) {

        Object[][] objects = new Object[items.length][items.length];

        for (int i = 0; i < items.length; i++) {

            for (int j = 0; j < items.length; j++) {
                objects[i][j] = items[i];
            }

        }

        return objects;

    }
}
