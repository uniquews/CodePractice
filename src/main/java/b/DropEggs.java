package b;

/**
 * Created by bohan on 5/23/17.
 */
public class DropEggs {
    /**
     * f(i, j) => have i eggs, j floors
     * f(i, j) = min{max{f(i - 1, x - 1), f(i, j - x)}}, x = 1 ... j
     *
     * @param n num of floors.
     * @param k num of eggs.
     */
    int eggDrop(int n, int k) {
        int[][] f = new int[k + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            f[1][j] = j;
        }
        for (int i = 1; i <= k; i++) {
            f[i][1] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int numOfTry = Math.max(f[i - 1][x - 1], f[i][j - x]) + 1;
                    min = Math.min(min, numOfTry);
                }
                f[i][j] = min;
            }
        }
        return f[k][n];
    }
}
