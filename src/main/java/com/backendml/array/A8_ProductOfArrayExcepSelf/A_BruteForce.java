package com.backendml.array.A8_ProductOfArrayExcepSelf;

public class A_BruteForce {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                product *= nums[j];

                // If product is already 0, it will stay 0 for the rest of this 'j' loop.
                if (product == 0) break;
            }
            result[i] = product;
        }
        return result;
    }
}
