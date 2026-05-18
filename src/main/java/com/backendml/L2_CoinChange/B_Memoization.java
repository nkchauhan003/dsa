package com.backendml.L2_CoinChange;

public class B_Memoization {
    public int coinChange(int[] coins, int amount) {
        // Memoization cache
        Integer[] memo = new Integer[amount + 1];
        return calculateMinCoins(coins, amount, memo);
    }

    private int calculateMinCoins(int[] coins, int amount, Integer[] memo) {

        // Exact amount formed
        if (amount == 0) return 0;

        // Invalid amount
        if (amount < 0) return -1;

        // Return cached result
        if (memo[amount] != null) return memo[amount];
        int minimumCoins = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            int result = calculateMinCoins(coins, amount - coin, memo);
            // Valid combination found
            if (result != -1)
                minimumCoins = Math.min(minimumCoins, result + 1);
        }

        // Store result
        memo[amount] = minimumCoins == Integer.MAX_VALUE ? -1 : minimumCoins;
        return memo[amount];
    }
}
