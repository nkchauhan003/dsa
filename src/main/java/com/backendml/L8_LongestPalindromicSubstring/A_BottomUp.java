package com.backendml.L8_LongestPalindromicSubstring;

public class A_BottomUp {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return s;

        int n = s.length();
        boolean[][] table = new boolean[n][n];
        return helper(s, n, table);
    }

    public String helper(String s, int n, boolean[][] table) {
        int start = 0, maxLength = 1;

        // Single character base case
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // Two consecutive character base case
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }

        }

        // Substrings of length 3 to n
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
