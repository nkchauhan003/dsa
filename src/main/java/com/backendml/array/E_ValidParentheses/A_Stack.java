package com.backendml.array.E_ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class A_Stack {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(')', '(', ']', '[', '}', '{');
        // ArrayDeque is faster than Stack because it is not synchronized
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!brackets.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || brackets.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
