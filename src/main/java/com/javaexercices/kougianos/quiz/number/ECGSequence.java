package com.javaexercices.kougianos.quiz.number;

import com.javaexercices.kougianos.util.MathUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * In the ECG Sequence (that always starts with the numbers 1 and 2), every number that succeeds is the smallest not
 * already present in the sequence and that shares a factor (excluding 1) with its preceding number. Every number
 * in the ECG Sequence (besides 1 and 2) has a different index from its natural index in a normal numeric sequence.
 * Given an integer n implement a function that returns its ECG Sequence Index.
 * <p>
 * Examples:
 * ecgSeqIndex(3) ➞ 4
 * ecgSeqIndex(5) ➞ 9
 * ecgSeqIndex(7) ➞ 13
 * <p>
 * First 11 numbers in ECG Sequence: 1, 2, 4, 6, 3, 9, 12, 8, 10, 5, 15, ...
 * Quiz URL: https://edabit.com/challenge/8dFqh23xMpfFf85Wb
 * See more at: https://mathworld.wolfram.com/EKGSequence.html
 */
public class ECGSequence {

    private ECGSequence() {

    }

    public static int ecgSequenceIndex(int n) {

        List<Integer> ecg = IntStream.range(1, 3)
                .boxed()
                .collect(Collectors.toList());

        while (true) {
            for (int i = 3; ; i++) {

                if (ecg.contains(i)) {
                    continue;
                }

                List<Integer> factorsOfLastNumInEcg =
                        (List<Integer>) MathUtils.findFactors(ecg.get(ecg.size() - 1), true);
                List<Integer> factorsOfCurrentNum =
                        (List<Integer>) MathUtils.findFactors(i, true);
                factorsOfLastNumInEcg.remove(factorsOfLastNumInEcg.get(0));
                factorsOfCurrentNum.remove(factorsOfCurrentNum.get(0));

                factorsOfLastNumInEcg.retainAll(factorsOfCurrentNum);
                if (!factorsOfLastNumInEcg.isEmpty()) {
                    ecg.add(i);
                    break;
                }

            }
            if (ecg.get(ecg.size() - 1) == n) {
                return ecg.size() - 1;
            }
        }

    }

}
