import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuaiwang on 2/6/17.
 */
public class ZombieInMatrix {
    public int zombie(int[][] grid) {
        // Write your code here

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int index = 0;

        while (!queue.isEmpty()) {
            index++;
            Queue<int[]> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                    grid[i - 1][j] = 1;
                    nextLevel.add(new int[]{i - 1, j});
                }
                if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                    grid[i + 1][j] = 1;
                    nextLevel.add(new int[]{i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                    grid[i][j - 1] = 1;
                    nextLevel.add(new int[]{i, j - 1});
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 0) {
                    grid[i][j + 1] = 1;
                    nextLevel.add(new int[] {i, j + 1});
                }
            }
            queue = nextLevel;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return index - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,0,0}, {1,0,0,2,1}, {0,1,0,0,0}};
        ZombieInMatrix test = new ZombieInMatrix();
        test.zombie(grid);
    }
}
