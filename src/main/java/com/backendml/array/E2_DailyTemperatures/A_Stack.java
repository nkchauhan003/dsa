package com.backendml.array.E2_DailyTemperatures;

import java.util.Stack;

public class A_Stack {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove indices of days that are cooler or equal to the current day
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] <= temperatures[i]) {
                indexStack.pop();
            }

            // If a warmer day exists in the stack, calculate the day difference
            if (!indexStack.isEmpty()) {
                result[i] = indexStack.peek() - i;
            }

            indexStack.push(i);
        }

        return result;
    }
}
