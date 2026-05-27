package com.backendml.M3_JumpGame;

public class A_Greedy {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Farthest index reachable so far

        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our maximum reach, we can't move forward
            if (i > maxReach) {
                return false;
            }

            // Update the maximum reach from the current index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Optimization: If we can already reach the last index, return true early
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
