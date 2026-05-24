package com.backendml.L9_MaximumProductSubarray;

public class B_PrefixAndSuffix {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int left_product = 1, right_product = 1;
        int result = nums[0];

        for (int i = 0; i < n; i++) {
            // if any of left or right product become 0, update it to 1
            if (left_product == 0) {
                left_product = 1;
            }
            if (right_product == 0) {
                right_product = 1;
            }

            // prefix product
            left_product *= nums[i];

            // suffix product
            right_product *= nums[n - 1 - i];

            result = Math.max(result, Math.max(left_product, right_product));
        }

        return result;
    }
}
