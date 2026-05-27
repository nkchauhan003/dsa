package com.backendml.P1_CountingBits;

public class A_BuiltInMethods {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            output[i] = Integer.bitCount(i);
        }
        return output;
    }
}
