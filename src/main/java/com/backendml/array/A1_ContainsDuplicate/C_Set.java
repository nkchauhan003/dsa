package com.backendml.array.A1_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class C_Set {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

        }
        return false;
    }
}
