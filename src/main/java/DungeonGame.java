/**
 * Created by shuaiwang on 6/23/17.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] f = new int[dungeon.length][dungeon[0].length];
        int m = dungeon.length;
        int n = dungeon[0].length;
        f[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : Math.abs(dungeon[m - 1][n - 1]) + 1;

        for (int i = m - 2; i >= 0; i--) {
            f[i][n - 1] = Math.max(f[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            f[m - 1][i] = Math.max(f[m - 1][i + 1] - dungeon[m - 1][i], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                f[i][j] = Math.max(Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return f[0][0];
    }


    public static void main(String[] args) {
        // [[1,-4,5,-99],[2,-2,-2,-1]]
//        int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] a = {{1,-4,5,-99}, {2,-2,-2,-1}};
        DungeonGame test = new DungeonGame();
        test.calculateMinimumHP(a);
    }
}
