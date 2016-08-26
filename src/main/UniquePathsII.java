package main;

/**
 * Created by shuaiwang on 8/25/16.
 */
public class UniquePathsII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
        {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1)
        {
            return 0;
        }

        int[][] f = new int[m][n];

        for (int i = 0; i < n; i++)
        {
            if (obstacleGrid[0][i] == 0)
            {
                f[0][i] = 1;
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < m; i++)
        {
            if (obstacleGrid[i][0] == 0)
            {
                f[i][0] = 1;
            }
            else
            {
                break;
            }
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (obstacleGrid[i][j] == 0)
                {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
                else
                {
                    f[i][j] = 0;
                }
            }
        }

        return f[m - 1][n - 1];

    }
}
