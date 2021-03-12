package com.javaexercices.kougianos.quiz.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BunchesTest {

    @Test
    void test01() {
        List<Fruit> b = new ArrayList<Fruit>();
        b.add(new Fruit("bananas", 1));
        List<Fruit> r = new ArrayList<Fruit>();
        b.forEach((f) -> { for(int i = 0; i < f.getQuantity(); i++) r.add(new Fruit(f.getName(), 1)); });
        assertEquals(r.toString(), Bunches.splitBunches(b).toString());
    }

    @Test
    void test02() {
        List<Fruit> b = new ArrayList<Fruit>();
        b.add(new Fruit("bananas", 2));
        List<Fruit> r = new ArrayList<Fruit>();
        b.forEach((f) -> { for(int i = 0; i < f.getQuantity(); i++) r.add(new Fruit(f.getName(), 1)); });
        assertEquals(r.toString(), Bunches.splitBunches(b).toString());
    }

    @Test
    void test03() {
        List<Fruit> b = new ArrayList<Fruit>();
        String[] fruit = new String[] {"bananas", "grapes"};
        int[] quantity = new int[] {2, 2};
        for(int i = 0; i < fruit.length; i++) b.add(new Fruit(fruit[i], quantity[i]));
        List<Fruit> r = new ArrayList<Fruit>();
        b.forEach((f) -> { for(int i = 0; i < f.getQuantity(); i++) r.add(new Fruit(f.getName(), 1)); });
        assertEquals(r.toString(), Bunches.splitBunches(b).toString());
    }

    @Test
    void test04() {
        List<Fruit> b = new ArrayList<Fruit>();
        String[] fruit = new String[] {"cherry tomatoes", "bananas", "grapes", "cherry tomatoes"};
        int[] quantity = new int[] {2, 1, 2, 3};
        for(int i = 0; i < fruit.length; i++) b.add(new Fruit(fruit[i], quantity[i]));
        List<Fruit> r = new ArrayList<Fruit>();
        b.forEach((f) -> { for(int i = 0; i < f.getQuantity(); i++) r.add(new Fruit(f.getName(), 1)); });
        assertEquals(r.toString(), Bunches.splitBunches(b).toString());
    }

}
