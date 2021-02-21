package com.javaexercices.kougianos.quiz.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * You bought a few bunches of fruit over the weekend. Create a function that splits
 * a bunch into singular objects inside an array.
 * <p>
 * splitBunches([
 * {name: "grapes", quantity: 2}
 * ]) ➞ [
 * {name: "grapes", quantity: 1},
 * {name: "grapes", quantity: 1}
 * ]
 * <p>
 * <p>
 * splitBunches([
 * {name: "currants", quantity: 1},
 * {name: "grapes", quantity: 2},
 * {name: "bananas", quantity: 2}
 * ]) ➞ [
 * {name: "currants", quantity: 1},
 * {name: "grapes", quantity: 1},
 * {name: "grapes", quantity: 1},
 * {name: "bananas", quantity: 1},
 * {name: "bananas", quantity: 1}
 * ]
 */
public class Bunches {

    public static List<Fruit> splitBunches(List<Fruit> bunches) {

        Iterator<Fruit> iter = bunches.iterator();
        List<Fruit> fruitList = new ArrayList<>();

        while (iter.hasNext()) {
            Fruit fruit = iter.next();

            for (int i = 0; i < fruit.getQuantity(); i++) {
                fruitList.add(new Fruit(fruit.getName(), 1));
            }
        }

        return fruitList;
    }

}

class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return String.format("{name: %s, quantity: %d}", this.name, this.quantity);
    }
}
