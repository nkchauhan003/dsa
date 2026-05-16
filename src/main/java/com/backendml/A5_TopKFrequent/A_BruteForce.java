package com.backendml.A5_TopKFrequent;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class A_BruteForce {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> unsortedMap = new HashMap<>();

        for (int num : nums) {
            unsortedMap.put(num, unsortedMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        int[] output = new int[k];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (i == k) break;
            output[i] = entry.getKey();
            i++;
        }
        return output;
    }
}
