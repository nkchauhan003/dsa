package com.backendml.H2_WordSearch;

public class A_DFSearch {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int i,
                        int j,
                        int k) {

        // Entire word matched
        if (k == word.length()) {
            return true;
        }

        // Boundary check
        if (i < 0 ||
                j < 0 ||
                i >= board.length ||
                j >= board[0].length) {

            return false;
        }

        // Character mismatch
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        char temp = board[i][j];

        // Mark visited
        board[i][j] = '#';

        boolean result =
                dfs(board, word, i, j - 1, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i + 1, j, k + 1);

        // Backtrack
        board[i][j] = temp;

        return result;
    }
}
