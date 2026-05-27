package com.backendml.M2_BoatsToSavePeople;

import java.util.Arrays;

public class A_TwoPointer {
    public int numRescueBoats(int[] people, int limit) {
        // 1. Sort the array so we can pair lightest with heaviest
        Arrays.sort(people);

        int boats = 0;
        int left = 0;                  // Lightest person
        int right = people.length - 1; // Heaviest person

        // 2. Meet in the middle
        while (left <= right) {
            // If the lightest and heaviest can share the boat
            if (people[left] + people[right] <= limit) {
                left++; // Lightest person gets on, move to next lightest
            }
            // Heaviest person always gets on a boat
            right--;
            boats++;    // Boat departs
        }

        return boats;
    }
}
