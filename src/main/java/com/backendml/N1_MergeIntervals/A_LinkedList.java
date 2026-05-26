package com.backendml.N1_MergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A_LinkedList {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> output = new LinkedList<>();

        for (int[] interval : intervals) {
            if (output.isEmpty() || output.getLast()[1] < interval[0]) {
                output.add(interval);
            } else {
                output.getLast()[1] = Math.max(output.getLast()[1], interval[1]);
            }
        }

        return output.toArray(new int[output.size()][]);
    }
}
