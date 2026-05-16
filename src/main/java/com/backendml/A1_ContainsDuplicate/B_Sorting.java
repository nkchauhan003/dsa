package com.backendml.A1_ContainsDuplicate;

import java.util.Arrays;

public class B_Sorting {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1])
                return true;

        }
        return false;
    }
}
