/**
 * Created by shuaiwang on 11/29/16.
 */
public class NumberofIslands {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
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

    private void dfs(boolean[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return;
        }

        if (grid[row][col] == false)
            return;

        grid[row][col] = false;
        for (int i = 0; i < x.length; i++) {
            dfs(grid, row + x[i], col + y[i]);
        }
    }
}
