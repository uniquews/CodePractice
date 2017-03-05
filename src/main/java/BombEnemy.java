/**
 * Created by shuaiwang on 2/26/17.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowHit = 0, result = 0;
        int[] columnHit = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHit = 0;
                    for (int k = j; k < grid[i].length && grid[i][k] != 'W'; k++) {
                        rowHit += grid[i][k] == 'E' ? 1 : 0;
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    columnHit[j] = 0;
                    for (int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        columnHit[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }

                if (grid[i][j] == '0')
                    result = Math.max(result, rowHit + columnHit[j]);
            }
        }
        return result;
    }
}
