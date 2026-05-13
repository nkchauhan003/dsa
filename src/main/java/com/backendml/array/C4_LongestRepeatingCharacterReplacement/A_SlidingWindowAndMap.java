package com.backendml.array.C4_LongestRepeatingCharacterReplacement;

import java.util.HashMap;
import java.util.Map;

public class A_SlidingWindowAndMap {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);

            maxCount = Math.max(maxCount, count.get(rightChar));

            // If the window is invalid, shrink it from the left
            if ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
