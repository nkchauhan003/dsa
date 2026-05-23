package com.backendml.L6_DecodeWays;

public class B_Memoization {

    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length() + 1];
        return helper(s, 0, memo);
    }

    public int helper(String s, int i, Integer[] memo) {
        if (i >= s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        if (memo[i] != null)
            return memo[i];

        boolean twoDigits = false;

        // Check if a 2-digit jump is possible and valid (between 10 and 26)
        if (i + 1 < s.length()) {
            int value = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (value >= 10 && value <= 26) {
                twoDigits = true;
            }
        }

        memo[i] = helper(s, i + 1, memo) + (twoDigits ? helper(s, i + 2, memo) : 0);
        return memo[i];
    }
}
