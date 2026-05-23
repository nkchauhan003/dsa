package com.backendml.L4_HouseRobber;

public class A_Recursion {
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    public int helper(int[] nums, int i) {
        // Base case: If we've gone past the last house, there's nothing to rob
        if (i >= nums.length)
            return 0;

        // Recursive case: Decide whether to rob the current house and skip the next one, or skip the current house
        return Math.max(helper(nums, i + 1), nums[i] + helper(nums, i + 2));
    }
}
