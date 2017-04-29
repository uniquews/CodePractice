/**
 * Created by shuaiwang on 4/27/17.
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int[][] f = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            f[i][i] = nums[i];
        }

        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i + len - 1 < nums.length; i++) {
                int j = i + len - 1;
                f[i][j] = (sum[j + 1] - sum[i]) - Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }

        return f[0][nums.length - 1] >= sum[nums.length] - f[0][nums.length - 1];
    }
}
