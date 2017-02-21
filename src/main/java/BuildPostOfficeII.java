import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 2/7/17.
 */
public class BuildPostOfficeII {
    public int shortestDistance(int[][] grid) {
        // Write your code here

        int numOfBuildings = 0;
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numOfBuildings++;
                    bfs(grid, i, j, distance, reach);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numOfBuildings) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, int i, int j, int[][] distance, int[][] reach) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size != 0) {
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];
                if (row - 1 >= 0 && grid[row - 1][column] == 0 && !visited[row - 1][column]) {
                    distance[row - 1][column] += level;
                    visited[row - 1][column] = true;
                    queue.add(new int[]{row - 1, column});
                    reach[row - 1][column]++;
                }

                if (row + 1 < grid.length && grid[row + 1][column] == 0 && !visited[row + 1][column]) {
                    distance[row + 1][column] += level;
                    visited[row + 1][column] = true;
                    queue.add(new int[]{row + 1, column});
                    reach[row + 1][column]++;
                }

                if (column - 1 >= 0 && grid[row][column - 1] == 0 && !visited[row][column - 1]) {
                    distance[row][column - 1] += level;
                    visited[row][column - 1] = true;
                    queue.add(new int[]{row, column - 1});
                    reach[row][column - 1]++;
                }

                if (column + 1 < grid[0].length && grid[row][column + 1] == 0 && !visited[row][column + 1]) {
                    distance[row][column + 1] += level;
                    visited[row][column + 1] = true;
                    queue.add(new int[]{row, column + 1});
                    reach[row][column + 1]++;
                }
                size--;
            }
        }
    }

    public static void main(String[] args) {
        //[[0,1,0,0,0],[1,0,0,2,1],[0,1,0,0,0]]
        int[][] grid = {{0,1,0,0,0}, {1,0,0,2,1}, {0,1,0,0,0}};
        BuildPostOfficeII test = new BuildPostOfficeII();
        System.out.print(test.shortestDistance(grid));
    }
}
