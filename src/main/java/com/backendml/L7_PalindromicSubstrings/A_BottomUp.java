package com.backendml.L7_PalindromicSubstrings;

public class A_BottomUp {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int n = s.length();
        boolean[][] table = new boolean[n][n];
        return helper(s, n, table);
    }

    public int helper(String s, int n, boolean[][] table) {
        int count = 0;

        // Single character base case
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
            count++;
        }

        // Two consecutive character base case
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                count++;
            }

        }

        // Substrings of length 3 to n
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
