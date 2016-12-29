/**
 * Created by shuaiwang on 12/21/16.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        // Write your code here
        int len = nums.length;
        int[] arr = new int[len + 2];

        int[][] dp = new int[len + 2][len + 2];

        System.arraycopy(nums, 0, arr, 1, len);

        arr[0] = 1;
        arr[len + 1] = 1;

        for (int i = 1; i <= len; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1]; // 20
        }

        // 1,4,5,1
        for (int i = 2; i <= len; i++) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j; k <= i; k++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][k - 1] + dp[k + 1][i] + arr[k] * arr[j - 1] * arr[i + 1]); // 4 * 1 * 1
                }
            }
        }

        return dp[1][len];
    }

    public static void main(String[] args) {
        BurstBalloons test = new BurstBalloons();
        int[] nums = {4, 1, 5, 10};
        System.out.print(test.maxCoins(nums));
    }
}
