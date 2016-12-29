/**
 * Created by shuaiwang on 12/21/16.
 */
public class StoneGameII {
    public int stoneGame2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int[][] dp = new int[len * 2][len * 2];
        int[] sum = new int[len * 2 + 1];

        for (int i = 1; i <= len * 2; i++) {
            sum[i] = sum[i - 1] + A[(i - 1) % len];
        }

        for (int i = 2 * len - 1; i >= 1; i--) {
            for (int j = i + 1; j <= 2 * len - 1 && j <= i + len - 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            result = Math.min(result, dp[i][i + len - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        StoneGameII test = new StoneGameII();
        int[] A = {3, 4, 3};
        System.out.print(test.stoneGame2(A));
    }
}
