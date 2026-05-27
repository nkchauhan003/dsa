package com.backendml.O3_SetMatrixZeroes;

public class A_MarkerStrategy {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;

        // 1. Identify if the first row contains any zeroes
        for (int j = 0; j < numCols; j++) {
            if (matrix[0][j] == 0) {
                zeroFirstRow = true;
                break;
            }
        }

        // 2. Identify if the first column contains any zeroes
        for (int i = 0; i < numRows; i++) {
            if (matrix[i][0] == 0) {
                zeroFirstCol = true;
                break;
            }
        }

        // 3. Use the first row and column as markers for the inner matrix
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 4. Update the inner matrix based on the markers
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. Update the first row
        if (zeroFirstRow) {
            for (int j = 0; j < numCols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 6. Update the first column
        if (zeroFirstCol) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
