package com.javaexercices.kougianos.quiz;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Challenge URL: https://www.hackerrank.com/challenges/java-dequeue/problem
 */
public class JavaDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        long count = 0;

        for (int i = 0; i < m; i++) deque.add(in.nextInt());
        count = deque.stream().distinct().count();
        for (int i = 0; i < n - m; i++) {
            count = Math.max(count, deque.stream().distinct().count());

            deque.removeFirst();
            deque.add(in.nextInt());
        }

        System.out.println(count);
    }


}
