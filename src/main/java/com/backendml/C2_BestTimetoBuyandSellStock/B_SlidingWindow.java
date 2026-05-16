package com.backendml.C2_BestTimetoBuyandSellStock;

public class B_SlidingWindow {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < n; i++) {
            int sellPrice = prices[i];
            if (sellPrice < buyPrice) {
                buyPrice = sellPrice;
            } else {
                maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
            }
        }

        return maxProfit;
    }
}
