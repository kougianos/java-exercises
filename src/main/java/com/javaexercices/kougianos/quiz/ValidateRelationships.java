package com.javaexercices.kougianos.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You will be given a string consisting of a list of integers and their relationships to their neighboring integers.
 * For instance:
 * "-15<-10<=0=0<5"
 * Test to see that all the relationships between the integers in the string are true.
 * If they are, return true. If they are not, return false.
 * <p>
 * validateTheRelationships("5>-1<0=0<-5>5=5") ➞ false
 * // This is false because 0 is not less than -5.
 * <p>
 * validateTheRelationships("-15<-10<=0=0<5") ➞ true
 * <p>
 * validateTheRelationships("0=807<1000<=1000>9990<-3605<=20") ➞ false
 * // This is false because 0 is not equal to 807.
 * <p>
 * This is a modification of Helen Yu's "Correct Signs" challenge.
 * As the examples above show, there could be negative numbers in the string.
 * The numbers will only be separated by: =, <, >, >=, <=
 * Tests will not contain any spaces.
 */
public class ValidateRelationships {

    public static boolean validateTheRelationships(String str) {

        List<String> symbolsList = Arrays.asList("=", "<", ">", ">=", "<=");
        List<String> symbols = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        StringBuilder tmpSymbol = new StringBuilder();
        StringBuilder tmpNumber = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (symbolsList.contains(String.valueOf(c))) {

                if (tmpNumber.length() > 0) {
                    numbers.add(tmpNumber.toString());
                    tmpNumber.setLength(0);
                }
                tmpSymbol.append(c);
                try {

                    char nextC = str.charAt(i + 1);
                    if (symbolsList.contains(String.valueOf(nextC))) {
                        tmpSymbol.append(nextC);
                        i++;
                    }

                } catch (IndexOutOfBoundsException e) {
                    break;
                }
                symbols.add(tmpSymbol.toString());
                tmpSymbol.setLength(0);

            } else if (String.valueOf(c).equals("-") || Character.isDigit(c)) {

                tmpNumber.append(c);
                if (i == str.length() - 1) {
                    numbers.add(tmpNumber.toString());
                    tmpNumber.setLength(0);
                }

            }

        }

        for (int i = 0; i < symbols.size(); i++) {

            String operation = symbols.get(i);
            switch (operation) {
                case "<":
                    if (!(Integer.parseInt(numbers.get(i)) < Integer.parseInt(numbers.get(i + 1)))) {
                        return false;
                    }
                    break;
                case ">":
                    if (!(Integer.valueOf(numbers.get(i)) > Integer.valueOf(numbers.get(i + 1)))) {
                        return false;
                    }
                    break;
                case "=":
                    if (!(Integer.valueOf(numbers.get(i)) == Integer.valueOf(numbers.get(i + 1)))) {
                        return false;
                    }
                    break;
                case "<=":
                    if (!(Integer.valueOf(numbers.get(i)) <= Integer.valueOf(numbers.get(i + 1)))) {
                        return false;
                    }
                    break;
                case ">=":
                    if (!(Integer.valueOf(numbers.get(i)) >= Integer.valueOf(numbers.get(i + 1)))) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }


        }

        return true;

    }

}
