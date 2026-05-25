package com.backendml.K4_GraphValidTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_DFS {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        // Start DFS from node 0. If there's a cycle, return false.
        if (!hasNoCycle(0, -1, visited, adj)) return false;

        // Condition 2: Check if all nodes were reached (fully connected)
        return visited.size() == n;
    }

    private boolean hasNoCycle(int curr, int parent, Set<Integer> visited, List<List<Integer>> adj) {
        visited.add(curr);
        for (int neighbor : adj.get(curr)) {
            // Skip the node we just came from
            if (neighbor == parent) continue;

            // If neighbor is already visited, a cycle is detected
            if (visited.contains(neighbor)) return false;

            // Recursive DFS call
            if (!hasNoCycle(neighbor, curr, visited, adj)) return false;
        }
        return true;
    }
}
