package com.backendml.L3_ClimbingStairs;

public class A_Recursion {
    public int climbStairs(int totalSteps) {
        // Base case: 1 way to climb 0 steps (do nothing)
        if (totalSteps == 0) {
            return 1;
        }

        // Base case: 0 ways if we overstepped the target
        if (totalSteps < 0) {
            return 0;
        }

        // Sum the ways to climb by taking 1 step and 2 steps
        return climbStairs(totalSteps - 1) + climbStairs(totalSteps - 2);
    }
}
