package com.javaexercices.kougianos.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testCalculateMinNumberInList() {
        var input1 = Arrays.asList(1, 2, 3, 4, 5, 6, -873, 0);
        assertEquals(-873, CollectionUtils.calculateMinOrMaxNumberInList(input1, true));

        var input2 = Arrays.asList(1.63, 2.1, 3.6, 4.3, 5.8, 6.2, -8873.0, 0.123);
        assertEquals(-8873.0, CollectionUtils.calculateMinOrMaxNumberInList(input2, true));

        var input3 = Arrays.asList(5.34f, 2.56f, -0.129f);
        assertEquals(-0.129f, CollectionUtils.calculateMinOrMaxNumberInList(input3, true));
        assertEquals(5.34f, CollectionUtils.calculateMinOrMaxNumberInList(input3, false));

        var input4 = Arrays.asList("String1", "String2");
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.calculateMinOrMaxNumberInList(input4, true));

        var input5 = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.calculateMinOrMaxNumberInList(input5, false));

        var input6 = new ArrayList<>();
        input6.add(5);
        input6.add(5.05);
        assertThrows(ClassCastException.class, () -> CollectionUtils.calculateMinOrMaxNumberInList(input6, false));
    }

    @Test
    void testMergeSets() {
        var set1 = Set.of(1, 2, 3);
        var set2 = Set.of(1, 3, 5, 6);
        var expected = Set.of(1, 2, 3, 5, 6);
        assertEquals(expected, CollectionUtils.mergeSets(set1, set2));
    }
}
