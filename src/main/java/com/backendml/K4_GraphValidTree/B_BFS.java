package com.backendml.K4_GraphValidTree;

import java.util.*;

/**
 * If the graph is connected (Condition 2) and has n-1 edges (Condition 1), it cannot have cycles.
 **/
public class B_BFS {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: A valid tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : adj.get(node)) {
                // If the neighbor is already visited, we skip it.
                if (visited.contains(neighbour))
                    continue;

                visited.add(neighbour);
                queue.offer(neighbour);
            }
        }

        // Condition 2: Check if all nodes are connected
        return visited.size() == n;
    }
}
