package com.backendml.F2_MinimumInRotatedSortedArray;

public class A_TwoPointers {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            // Minimum must be in the right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Minimum is at mid or in the left half
            else {
                high = mid;
            }
        }
        // At the end of the loop, low and high will point to the minimum element
        return nums[low];
    }
}
