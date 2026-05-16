package com.backendml.F1_BinarySearch;

public class A_TwoPointers {
    public int search(int[] nums, int target) {
        // Check for null first to prevent NullPointerException
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
