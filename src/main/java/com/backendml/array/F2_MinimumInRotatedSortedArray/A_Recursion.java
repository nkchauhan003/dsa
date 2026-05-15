package com.backendml.array.F2_MinimumInRotatedSortedArray;

public class A_Recursion {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums[0] <= nums[nums.length - 1]) return nums[0];

        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        if (end < start) return -1;

        int mid = start + (end - start) / 2;

        // Check if mid or mid + 1 is the inflection point
        if (mid > start && nums[mid] < nums[mid - 1]) return nums[mid];
        if (mid < end && nums[mid] > nums[mid + 1]) return nums[mid + 1];

        // Decide which half to search
        if (nums[mid] > nums[end]) {
            return binarySearch(nums, mid + 1, end);
        } else {
            return binarySearch(nums, start, mid - 1);
        }
    }
}
