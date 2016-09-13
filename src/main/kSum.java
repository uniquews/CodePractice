package main;

/**
 * Created by shuaiwang on 9/12/16.
 */
public class kSum {
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (k == 0 && target == 0) {
            return 1;
        }

        if (A == null || k == 0 || target == 0) {
            return 0;
        }

        int[][][] f = new int[A.length + 1][k + 1][target + 1];

        f[0][0][0] = 1;
        for (int i = 1; i <= A.length; i++) {
            f[i][0][0] = 1;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= target; m++) {
                    f[i][j][m] = f[i - 1][j][m];
                    if (m - A[i - 1] >= 0) {
                        f[i][j][m] += f[i - 1][j - 1][m - A[i - 1]];
                    }
                }
            }
        }

        return f[A.length][k][target];
    }
}
