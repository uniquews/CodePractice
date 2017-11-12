/**
 * Created by shuaiwang on 3/30/17.
 */
public class IslandPerimeter {
//    public int islandPerimeter(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0] == null) {
//            return 0;
//        }
//        int result = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    result += 4;
//                    if (i > 0 && grid[i - 1][j] == 1) {
//                        result -= 2;
//                    }
//
//                    if (j > 0 && grid[i][j - 1] == 1) {
//                        result -=2;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    int result = 0;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};


    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        result += 4;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];

            if (nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid[0].length && grid[nextR][nextC] == 1) {
                result -= 1;
                dfs(grid, nextR, nextC, visited);
            }
        }
    }
}
