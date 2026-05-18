package com.backendml.K3_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

public class A_Matrix {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, n - 1, j, heights[n - 1][j]);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, m - 1, heights[i][m - 1]);
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (pacific[i][j] && atlantic[i][j])
                    list.add(List.of(i, j));
            }
        }
        return list;
    }


    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int borderHeight) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || ocean[i][j] || heights[i][j] < borderHeight)
            return;

        ocean[i][j] = true;

        dfs(heights, ocean, i + 1, j, heights[i][j]);
        dfs(heights, ocean, i - 1, j, heights[i][j]);
        dfs(heights, ocean, i, j + 1, heights[i][j]);
        dfs(heights, ocean, i, j - 1, heights[i][j]);
    }
}
