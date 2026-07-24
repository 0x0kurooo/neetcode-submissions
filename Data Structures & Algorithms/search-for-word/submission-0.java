class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] used = new boolean[rows][];
        for (int i = 0; i < rows; i++) {
            used[i] = new boolean[cols];
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = board[row][col];
                if (c != word.charAt(0))
                    continue;
                if (backtrack(board, used, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(
        char[][] board, boolean[][] used, String word, int row, int col, int wordIdx) {
        if (wordIdx == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (used[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        used[row][col] = true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions) {
            if (backtrack(board, used, word, row + direction[0], col + direction[1], wordIdx + 1)) {
                return true;
            }
        }
        used[row][col] = false;
        return false;
    }
}