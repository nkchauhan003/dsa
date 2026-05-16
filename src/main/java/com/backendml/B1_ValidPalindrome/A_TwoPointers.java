package com.backendml.B1_ValidPalindrome;

public class A_TwoPointers {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (!Character.isLetterOrDigit(ci)) {
                i++;
            } else if (!Character.isLetterOrDigit(cj)) {
                j--;
            } else {
                // Compare lowercase versions
                if (Character.toLowerCase(ci) != Character.toLowerCase(cj)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
