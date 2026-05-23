package com.backendml.L5_HouseRobber_II;

public class A_Recursion {
    public int rob(int[] nums) {
        return Math.max(nums[0] + helper(nums, 2, true), helper(nums, 1, false));
    }

    public int helper(int[] nums, int i, boolean excludeLast) {
        if (i >= nums.length || (excludeLast && i == nums.length - 1))
            return 0;
        return Math.max(helper(nums, i + 1, excludeLast), nums[i] + helper(nums, i + 2, excludeLast));
    }
}
