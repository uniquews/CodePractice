import java.util.Arrays;

/**
 * Created by shuaiwang on 2/21/17.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // Write your code here

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares test = new PerfectSquares();
        System.out.print(test.numSquares(12));
    }
}
