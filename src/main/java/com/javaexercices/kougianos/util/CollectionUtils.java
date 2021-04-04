package com.javaexercices.kougianos.util;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils {

    private CollectionUtils() {

    }

    /**
     * Return true if the 2 input lists have at least one element in common, otherwise return false.
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
     * @param primitiveList input list
     * @return List
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
}
