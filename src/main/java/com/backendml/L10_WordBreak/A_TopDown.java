package com.backendml.L10_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_TopDown {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return helper(s, wordSet, 0, memo);
    }

    public boolean helper(String s, Set<String> wordSet, int start, Boolean[] memo) {
        // Base case: If we've reached the end of the string, it's a valid segmentation
        if (start >= s.length())
            return true;

        // Return the cached result if we've been here before
        if (memo[start] != null)
            return memo[start];

        // Try every possible ending position for the current word
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(start, i)) && helper(s, wordSet, i, memo)) {
                return memo[start] = true;
            }
        }

        // Cache the failure before returning
        return memo[start] = false;
    }
}
