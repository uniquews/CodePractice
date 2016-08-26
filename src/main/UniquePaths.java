package main;

/**
 * Created by shuaiwang on 8/25/16.
 */
public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here

        if (m == 0 || n == 0)
        {
            return 0;
        }

        int[][] f = new int[m][n];

        for (int i = 0; i < n; i ++)
        {
            f[0][i] = 1;
        }

        for (int j = 1; j < m; j++)
        {
            f[j][0] = 1;
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
