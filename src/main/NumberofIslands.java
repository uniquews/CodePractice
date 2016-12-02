package main;

/**
 * Created by shuaiwang on 11/29/16.
 */
public class NumberofIslands {
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row == grid.length || column == grid[0].length) {
            return;
        }

        if (grid[row][column]) {
            grid[row][column] = false;
            dfs(grid, row + 1, column);
            dfs(grid, row, column + 1);
            dfs(grid, row - 1, column);
            dfs(grid, row, column - 1);
        }
    }
}
