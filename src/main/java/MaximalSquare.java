/**
 * Created by shuaiwang on 12/17/16.
 */
public class MaximalSquare {
    public int maxSquare(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] f = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }

                if (f[i][j] > ans)
                    ans = f[i][j];
            }
        }
        return ans * ans;
    }
}
