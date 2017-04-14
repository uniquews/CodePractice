/**
 * Created by shuaiwang on 4/14/17.
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
            f[i][i] = 0; //只有一个数字肯定不需要pay
        }

        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    if (k == start) {
                        f[start][end] = Math.min(f[start][end], f[k + 1][end] + k);
                    } else if (k == end) {
                        f[start][end] = Math.min(f[start][end], f[start][k - 1] + k);
                    } else {
                        f[start][end] = Math.min(f[start][end], Math.max(f[start][k - 1], f[k + 1][end]) + k);
                    }
                }
            }
        }
        return f[1][n];
    }
}
