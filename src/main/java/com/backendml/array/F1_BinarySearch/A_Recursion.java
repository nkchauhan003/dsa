package com.backendml.array.F1_BinarySearch;

public class A_Recursion {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        if (end < start) return -1; // Base case

        int mid = start + ((end - start) / 2); // Midpoint

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1); // Search left half
        } else {
            return binarySearch(nums, target, mid + 1, end);   // Search right half
        }
    }
}
