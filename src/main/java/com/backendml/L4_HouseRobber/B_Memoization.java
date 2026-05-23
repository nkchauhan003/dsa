package com.backendml.L4_HouseRobber;

public class B_Memoization {

    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length + 1];
        return helper(nums, 0, memo);
    }

    public int helper(int[] nums, int i, Integer[] memo) {
        // Base case: If we've gone past the last house, there's nothing to rob
        if (i >= nums.length)
            return 0;

        // Check if the result for index i is already computed
        if (memo[i] == null)
            memo[i] = Math.max(helper(nums, i + 1, memo), nums[i] + helper(nums, i + 2, memo));
        return memo[i];
    }
}
