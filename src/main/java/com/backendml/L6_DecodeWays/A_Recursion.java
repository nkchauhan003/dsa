package com.backendml.L6_DecodeWays;

public class A_Recursion {
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    public int helper(String s, int i) {
        if (i >= s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        boolean twoDigits = false;

        // Check if a 2-digit jump is possible and valid (between 10 and 26)
        if (i + 1 < s.length()) {
            int value = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (value >= 10 && value <= 26) {
                twoDigits = true;
            }
        }

        return helper(s, i + 1) + (twoDigits ? helper(s, i + 2) : 0);
    }
}
