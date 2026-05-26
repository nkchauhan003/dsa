package com.backendml;

public class L11_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length + 1];
        return helper(nums, 0, -1, memo);
    }

    public int helper(int[] nums, int i, int maxSoFarIdx, Integer[][] memo) {
        if (i >= nums.length)
            return 0;

        if (memo[i][maxSoFarIdx + 1] != null)
            return memo[i][maxSoFarIdx + 1];

        // If prevIdx is -1, maxSoFar acts as Integer.MIN_VALUE
        if (maxSoFarIdx != -1 && nums[i] <= nums[maxSoFarIdx])
            return memo[i][maxSoFarIdx + 1] = helper(nums, i + 1, maxSoFarIdx, memo);

        return memo[i][maxSoFarIdx + 1] = Math.max(1 + helper(nums, i + 1, i, memo), helper(nums, i + 1, maxSoFarIdx, memo));
    }
}
