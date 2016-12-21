/**
 * Created by shuaiwang on 12/20/16.
 *
 * dp[i][j] means the minimun sum of combining stones from index i to index j inclusive.
 * dp[i][j] =  Math.min(dp[i][k], dp[k + 1][j]) + sum[i][j]  0 <= i < A.length, i <= j < A.length  i <= k < j
 *
 * sum[i][j] means the sum of stones starting from index i and ended with index j (inclusive)
 *
 *
 */

public class StoneGame {
    public int stoneGame(int[] A) {
        // Write your code here

        if (A == null || A.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][A.length];
        int[] sum = new int[A.length + 1];

        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[i - 1][i - 1] = 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i] + (sum[i + 1] - sum[j]));
                }
            }
        }
        return dp[0][A.length - 1];

    }

    public static void main(String[] args) {
        StoneGame test = new StoneGame();
        int[] A = {1,1,1,1};
        System.out.print(test.stoneGame(A));
    }
}
