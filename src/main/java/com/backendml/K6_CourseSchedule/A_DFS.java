package com.backendml.K6_CourseSchedule;

import java.util.ArrayList;
import java.util.List;

public class A_DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] visited) {
        if (visited[node] == 1) return true;  // Cycle detected
        if (visited[node] == 2) return false; // Already verified safe

        visited[node] = 1; // Mark as visiting

        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, visited)) {
                return true;
            }
        }

        visited[node] = 2; // Mark as fully processed
        return false;
    }
}
