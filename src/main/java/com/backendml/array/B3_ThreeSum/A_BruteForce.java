package com.backendml.array.B3_ThreeSum;

import java.util.*;

public class A_BruteForce {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];

                        // Manually ordered: replaced O(k log k) sorting (where k=3) with O(1) math comparisons.
                        int min = Math.min(a, Math.min(b, c));
                        int max = Math.max(a, Math.max(b, c));
                        int mid = (a + b + c) - min - max;

                        output.add(Arrays.asList(min, mid, max));
                    }
                }
            }
        }
        return new ArrayList(output);
    }
}
