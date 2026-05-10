package com.backendml.array.A5_TopKFrequent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B_BucketSort {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k]; // Preferred array declaration style

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Use the diamond operator <> for cleaner code
        List<Integer>[] buckets = new List[nums.length + 1];

        // Use forEach for cleaner map iteration
        counts.forEach((val, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(val);
        });

        int index = 0;
        // Search from highest frequency downwards
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) return result;
                }
            }
        }

        return result;
    }
}
