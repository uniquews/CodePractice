/**
 * Created by shuaiwang on 12/28/16.
 */


/**
 * f[i][j] means the max value the player can get picking from index i to index j coins.
 * f[i][j] = sum[i][j] - Math.min(f[i + 1][j], f[i][j - 1])
 */
public class CoinsInALineIII {
    public boolean firstWillWin(int[] values) {
        // write your code here
        int[][] f = new int [values.length][values.length];
        int[] sum = new int[values.length + 1];

        for (int i = 1; i <= values.length; i++) {
            sum[i] = sum[i - 1] + values[i - 1];
        }

        for (int i = 0; i < values.length; i++) {
            f[i][i] = values[i];
        }

        for (int len = 2; len <= values.length; len++) {
            for (int i = 0; i + len <= values.length; i++) {
                int j = i + len - 1;

                int s = sum[j + 1] - sum[i];
                f[i][j] = s - Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][values.length - 1] > sum[values.length] / 2;
    }
}
