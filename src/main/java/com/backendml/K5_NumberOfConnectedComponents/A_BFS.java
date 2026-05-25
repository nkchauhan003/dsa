package com.backendml.K5_NumberOfConnectedComponents;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_BFS {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            // If the node has not been visited, it means we have found a new component.
            if (!visited[i]) {
                visited[i] = true;
                queue.offer(i);
                components++;
            }
            // Perform BFS to visit all nodes in the current component.
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbour : adj.get(node)) {
                    // Check if the neighbour has already been visited. If it has, skip it.
                    if (visited[neighbour]) {
                        continue;
                    }
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return components;
    }
}
