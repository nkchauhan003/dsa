package com.backendml.C1_MaximumAverageSubarrayI;

public class A_SlidingWindow {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int currentSum = 0;
        if (n < k)
            return 0;
        int left = 0, right = k - 1;

        for (int i = left; i <= right; i++) {
            currentSum += nums[i];
        }
        int maxSum = currentSum;

        while (right < n - 1) {
            currentSum = currentSum + (nums[++right] - nums[left++]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return (double) maxSum / k;
    }
}
