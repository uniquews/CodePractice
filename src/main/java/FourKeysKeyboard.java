/**
 * Created by shuaiwang on 8/15/17.
 */
public class FourKeysKeyboard {
    /**
        在按过一次Ctrl-A/c/v之后  后面只可能是Ctrl-A/c/v或者是Ctrl-v/v/v... 出现单独的A肯定不是最优的
     */
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                // i - j 中减掉 2次分别死Ctrl-A and Ctrl-C 就是i - j - 2 次Ctrl - V，加上本身的dp[j] 一共是i - j - 1次dp[j]
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }
}
