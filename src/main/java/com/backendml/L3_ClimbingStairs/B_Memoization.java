package com.backendml.L3_ClimbingStairs;

public class B_Memoization {

    public int climbStairs(int n) {
        // Create a memoization array to store results of subproblems
        Integer[] memo = new Integer[n + 1];
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, Integer[] memo) {
        // Base case: 1 way to climb 0 steps (do nothing)
        if (n == 0)
            return 1;

        // Base case: 0 ways if we overstepped the target
        if (n < 0)
            return 0;

        // Check if the result for n steps is already computed
        if (memo[n] == null)
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }
}
