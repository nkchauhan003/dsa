package com.backendml.M1_MaximumSubarray;

public class A_KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        // Handle edge case for empty array
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add the current element to the existing subarray
            // or start a brand new subarray from the current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Track the highest sum seen so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
