package com.backendml.L2_CoinChange;

public class A_Recursion {
    public int coinChange(int[] coins, int amount) {
        // Exact amount formed
        if (amount == 0) {
            return 0;
        }
        // Invalid amount
        if (amount < 0) {
            return -1;
        }
        int minimumCoins = Integer.MAX_VALUE;
        // Try every coin
        for (int coin : coins) {
            int remainingCoins = coinChange(coins, amount - coin);
            // Valid combination found
            if (remainingCoins != -1) {
                minimumCoins = Math.min(minimumCoins, 1 + remainingCoins);
            }
        }
        return minimumCoins == Integer.MAX_VALUE ? -1 : minimumCoins;
    }
}
