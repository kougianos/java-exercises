package com.javaexercices.kougianos.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionUtilsTest {

    @Test
    void testCommonElements() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4, 5, 6));

        assertFalse(CollectionUtils.doListsHaveCommonElements(l1, l2));

        l2.add(2);
        assertTrue(CollectionUtils.doListsHaveCommonElements(l1, l2));
    }

    @Test
    void testPrimitivesToList() {

        List<Number> list = CollectionUtils.primitivesToList(new int[]{4, 2, 6, 9});
        assertEquals(9, list.get(list.size() - 1));
        assertEquals(4, list.size());

    }
}
