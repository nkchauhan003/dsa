package com.backendml.array.B4_ContainerWithMostWater;

public class B_TwoPointer {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            // Calculate the limiting height and the distance between pointers
            int currentHeight = Math.min(heights[left], heights[right]);
            int width = right - left;

            int currentArea = currentHeight * width;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter wall to potentially find a taller one
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
