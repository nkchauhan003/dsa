package com.backendml.array.C4_LongestRepeatingCharacterReplacement;

public class A_SlidingWindowAndArray {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar - 'A'] = count[rightChar - 'A'] + 1;

            maxCount = Math.max(maxCount, count[rightChar - 'A']);

            // If the window is invalid, shrink it from the left
            if ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A'] = count[leftChar - 'A'] - 1;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
