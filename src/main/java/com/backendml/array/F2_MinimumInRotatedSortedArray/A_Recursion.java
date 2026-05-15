package com.backendml.array.F2_MinimumInRotatedSortedArray;

public class A_Recursion {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        // If the array is not rotated at all, the first element is the minimum
        if (nums[0] <= nums[n - 1]) return nums[0];

        return binarySearch(nums, 0, n - 1);
    }

    public int binarySearch(int[] nums, int start, int end) {
        if (end < start) return -1;

        int mid = start + (end - start) / 2; // Fixed midpoint calculation

        // Check if mid itself is the inflection point (minimum element)
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }

        // Check if mid + 1 is the inflection point
        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        // If mid element is greater than the end element, the minimum is in the right half
        if (nums[mid] > nums[end]) {
            return binarySearch(nums, mid + 1, end);
        } else {
            // Otherwise, the minimum is in the left half
            return binarySearch(nums, start, mid - 1);
        }
    }
}
