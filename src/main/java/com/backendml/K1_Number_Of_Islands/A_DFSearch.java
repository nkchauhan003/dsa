package com.backendml.K1_Number_Of_Islands;

public class A_DFSearch {
    public class NumberOfIslands {

        public int numIslands(char[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // Found a new island
                    if (grid[i][j] == '1') {
                        count++;
                        sinkIsland(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void sinkIsland(char[][] grid,
                                int i,
                                int j) {
            // Boundary check
            if (i < 0 ||
                    j < 0 ||
                    i >= grid.length ||
                    j >= grid[0].length) {

                return;
            }

            // Water cell
            if (grid[i][j] == '0') {
                return;
            }

            // Mark as visited/water
            grid[i][j] = '0';

            // Visit all 4 directions
            sinkIsland(grid, i, j - 1);
            sinkIsland(grid, i, j + 1);
            sinkIsland(grid, i - 1, j);
            sinkIsland(grid, i + 1, j);
        }
    }
}
