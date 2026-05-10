package com.backendml.array.A3_IsAnagram;

import java.util.HashMap;
import java.util.Map;

public class B_Map {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!charCount.containsKey(t.charAt(i)))
                return false;

            charCount.put(t.charAt(i), charCount.get(t.charAt(i)) - 1);

            if (charCount.get(t.charAt(i)) < 0)
                return false;

        }

        return true;
    }
}
