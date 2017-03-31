/**
 * Created by shuaiwang on 3/30/17.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -=2;
                    }
                }
            }
        }
        return result;
    }
}
