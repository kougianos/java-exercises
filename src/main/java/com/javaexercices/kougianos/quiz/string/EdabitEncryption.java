package com.javaexercices.kougianos.quiz.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Challenge URL:
 * https://edabit.com/challenge/jfCsugyp9BSLYEtwb
 */
public class EdabitEncryption {

    public static String encryption(String s) {

        s = s.replace(" ", "");
        int length = s.length();
        int rows = (int) Math.floor(Math.sqrt(length));
        int columns = (int) Math.ceil(Math.sqrt(length));
        String[] grid = splitAfterNChars(s, columns);
        List<String> matrix = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int j=0;

        while (true) {
            for (String value : grid) {
                try {
                    sb.append(value.charAt(j));
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
            matrix.add(String.valueOf(sb));
            if(j==rows) {
                break;
            }
            sb.setLength(0);
            j++;
        }
        return String.join(" ", matrix);
    }

    private static String[] splitAfterNChars(String input, int splitLen) {
        return input.split(String.format("(?<=\\G.{%1$d})", splitLen));
    }

}
