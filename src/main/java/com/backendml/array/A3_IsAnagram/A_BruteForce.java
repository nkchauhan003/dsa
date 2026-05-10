package com.backendml.array.A3_IsAnagram;

import java.util.Arrays;

public class A_BruteForce {
    public boolean isAnagram(String s, String t) {
        char[] sa = s.toCharArray();
        char[] st = t.toCharArray();

        Arrays.sort(sa);
        Arrays.sort(st);

        s = new String(sa);
        t = new String(st);

        return s.equals(t);
    }
}
