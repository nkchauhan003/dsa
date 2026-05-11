package com.backendml.array.A7_LongestConsecutiveSequence;

public class A_BruteForce_n3 {
    // Check if a specific number exists in the array
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    public int longestForThisElement(int element, int[] nums) {
        int count = 1;
        // Keep looking for the next consecutive number as long as it exists
        while (contains(nums, element + count)) {
            count++;
        }
        return count;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int maxLength = 0;
        for (int num : nums) {
            maxLength = Math.max(maxLength, longestForThisElement(num, nums));
        }
        return maxLength;
    }
}
