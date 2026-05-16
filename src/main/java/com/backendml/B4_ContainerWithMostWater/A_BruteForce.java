package com.backendml.B4_ContainerWithMostWater;

public class A_BruteForce {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int containerHeight = Math.min(heights[i], heights[j]);
                int containerWidth = j - i;

                int currentArea = containerHeight * containerWidth;

                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }
}
