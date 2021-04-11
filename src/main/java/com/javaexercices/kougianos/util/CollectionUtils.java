package com.javaexercices.kougianos.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {

    private CollectionUtils() {

    }

    /**
     * Return true if the 2 input lists have at least one element in common, otherwise return false.
     *
     * @param c1 first list
     * @param c2 second list
     * @return boolean
     */
    public static boolean doListsHaveCommonElements(List<?> c1, List<?> c2) {

        if (!c1.isEmpty() && !c2.isEmpty() && c1.get(0).getClass().equals(c2.get(0).getClass())) {
            List<?> l = new ArrayList<>(c1);
            l.retainAll(c2);
            return !l.isEmpty();
        } else {
            return false;
        }
    }

    /**
     * Convert a primitive array to List. Only supports int[], long[] and double[]. Other arrays (eg float[]) will
     * have an empty collection returned instead.
     *
     * @param primitiveList input list
     * @return List<Number>
     */
    public static List<Number> primitivesToList(Object primitiveList) {
        var x = primitiveList.getClass().getComponentType().getName();
        switch (x) {
            case "int":
                return Arrays.stream((int[]) primitiveList).boxed().collect(Collectors.toList());
            case "long":
                return Arrays.stream((long[]) primitiveList).boxed().collect(Collectors.toList());
            case "double":
                return Arrays.stream((double[]) primitiveList).boxed().collect(Collectors.toList());
            default:
                return Collections.emptyList();
        }
    }

    /**
     * Returns the element with the minimum value in a list of numbers.
     * Supported classes:
     * java.lang.Integer
     * java.lang.Double
     * java.lang.Float
     *
     * @param numberList input list of numbers
     * @return Number minimum number
     * @throws IllegalArgumentException if numberList is empty, or if input class is unsupported.
     * @throws ClassCastException if numberList contains elements that are not the same type.
     */
    public static Number calculateMinNumberInList(List<?> numberList) {

        if (numberList.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty.");
        }
        String c = numberList.get(0).getClass().getName();
        try {
            switch (c) {
                case "java.lang.Integer":
                    return numberList.stream().mapToInt(e -> (int) e).min().getAsInt();
                case "java.lang.Double":
                    return numberList.stream().mapToDouble(e -> (double) e).min().getAsDouble();
                case "java.lang.Float":
                    return (float) numberList.stream().mapToDouble(e -> (float) e).min().getAsDouble();
                default:
                    throw new IllegalArgumentException("Method supports only Integer, Double, and Float classes");
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("List must contain elements of same type. It cannot contain a mix of " +
                    "Integer, Float, Double or other Object types.");
        }

    }
}
