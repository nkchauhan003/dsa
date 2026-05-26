package com.backendml.L12_LongestCommonSubsequence;

public class A_TopDown {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, memo);
    }

    public int helper(String text1, String text2, int i, int j, Integer[][] memo) {
        if (i == text1.length() || j == text2.length())
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        // If characters match, we can include this character in the LCS and move both pointers
        if (text1.charAt(i) == text2.charAt(j))
            return memo[i][j] = 1 + helper(text1, text2, i + 1, j + 1, memo);

        // If characters don't match, we have two options: move the pointer in text1 or move the pointer in text2
        return memo[i][j] = Math.max(helper(text1, text2, i + 1, j, memo), helper(text1, text2, i, j + 1, memo));

    }
}
