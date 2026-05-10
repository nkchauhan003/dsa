package com.backendml.array.A2_TwoSum;

import java.util.Arrays;

public class A_BruteForce {
    public int[] twoSum(int[] nums, int target) {
        int[][] numsIndex = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            numsIndex[i] = new int[]{nums[i], i};
        }
        Arrays.sort(numsIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, j = numsIndex.length - 1;

        while (i < j) {
            int total = numsIndex[i][0] + numsIndex[j][0];
            if (total < target)
                i++;
            else if (total > target)
                j--;
            else
                return new int[]{numsIndex[i][1], numsIndex[j][1]};
        }
        return new int[]{};
    }
}
