class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                if (grid[row][col] == '1') {
                    count ++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        // check boundary
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        // Skip the 0
        if (grid[row][col] == '0') {
            return;
        }

        // Expand the connected land to prevent duplicated counting
        grid[row][col] = '0'; // Marked this as visited
        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }
}