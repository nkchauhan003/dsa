package com.backendml.L9_MaximumProductSubarray;

public class A_DynamicProgramming {
    public int maxProduct(int[] nums) {
        // Initialize the global maximum result with the first element
        int res = nums[0];

        // curMax and curMin store the max/min products of subarrays ending at the current position
        int curMax = 1, curMin = 1;

        for (int n : nums) {
            // Case 1: If the number is 0, reset the tracking products to 1.
            // A zero breaks any continuous product subarray.
            if (n == 0) {
                curMax = 1;
                curMin = 1;
                res = Math.max(res, 0); // Ensure 0 itself is considered as a potential max result
                continue;
            }

            // Store the previous curMax before it gets overwritten,
            // as it is needed to calculate the new curMin.
            int tmp = curMax * n;

            // Case 2: Update curMax by comparing three possibilities:
            // 1. Current number times previous max (if positive stays positive, or negative stays negative)
            // 2. Current number times previous min (negative * negative becomes positive)
            // 3. Starting a brand new subarray from the current number 'n'
            curMax = Math.max(Math.max(n * curMax, n * curMin), n);

            // Case 3: Update curMin using the exact same three possibilities.
            // We use 'tmp' here instead of 'curMax' because 'curMax' has already been updated.
            curMin = Math.min(Math.min(tmp, n * curMin), n);

            // Update the global maximum product found so far
            res = Math.max(res, curMax);
        }

        return res;
    }
}
