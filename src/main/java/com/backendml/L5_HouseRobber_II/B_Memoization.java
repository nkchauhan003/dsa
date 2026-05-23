package com.backendml.L5_HouseRobber_II;

public class B_Memoization {

    public int rob(int[] nums) {
        Integer[][] memo = new Integer[nums.length + 1][2];
        return Math.max(nums[0] + helper(nums, 2, 1, memo), helper(nums, 1, 0, memo));
    }

    public int helper(int[] nums, int i, int excludeLast, Integer[][] memo) {
        if (i >= nums.length || (excludeLast == 1 && i == nums.length - 1))
            return 0;
        if (memo[i][excludeLast] == null)
            memo[i][excludeLast] = Math.max(helper(nums, i + 1, excludeLast, memo), nums[i] + helper(nums, i + 2, excludeLast, memo));
        return memo[i][excludeLast];
    }
}
