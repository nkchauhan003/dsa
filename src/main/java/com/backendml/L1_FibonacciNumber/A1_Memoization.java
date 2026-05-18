package com.backendml.L1_FibonacciNumber;

public class A1_Memoization {
    public int fib(int n) {
        // Memoization cache
        Integer[] memo = new Integer[n + 1];
        return calculateFib(n, memo);
    }

    private int calculateFib(int n, Integer[] memo) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // Return cached result
        if (memo[n] != null) {
            return memo[n];
        }
        // Compute Fibonacci recursively
        int currentFib =
                calculateFib(n - 1, memo)
                        + calculateFib(n - 2, memo);
        // Store result in cache
        memo[n] = currentFib;
        return currentFib;
    }
}
