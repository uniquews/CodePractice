/**
 * Created by shuaiwang on 12/21/16.
 */
public class BurstBalloons {
//    public int maxCoins(int[] nums) {
//        // Write your code here
//        int len = nums.length;
//        int[] arr = new int[len + 2];
//
//        int[][] dp = new int[len + 2][len + 2];
//
//        System.arraycopy(nums, 0, arr, 1, len);
//
//        arr[0] = 1;
//        arr[len + 1] = 1;
//
//        for (int i = 1; i <= len; i++) {
//            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1]; // 20
//        }
//
//        // 1,4,5,1
//        for (int i = 2; i <= len; i++) {
//            for (int j = i - 1; j >= 1; j--) {
//                for (int k = j; k <= i; k++) {
//                    dp[j][i] = Math.max(dp[j][i], dp[j][k - 1] + dp[k + 1][i] + arr[k] * arr[j - 1] * arr[i + 1]); // 4 * 1 * 1
//                }
//            }
//        }
//
//        return dp[1][len];
//    }

    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] balloons = new int[nums.length + 2];
        int[][] f = new int[nums.length + 2][nums.length + 2];
        System.arraycopy(nums, 0, balloons, 1, nums.length);

        balloons[0] = 1;
        balloons[nums.length + 1] = 1;

        f[0][0] = 1;
        f[nums.length + 1][nums.length + 1] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (i == j) {
                    f[j][i] = balloons[i] * balloons[i - 1] * balloons[i + 1]; // 初始化容易错。。。
                } else {
                    for (int k = j; k <= i; k++) {
                        f[j][i] = Math.max(f[j][i], f[j][k - 1] + f[k + 1][i] +
                                balloons[j - 1] * balloons[k] * balloons[i + 1]);
                    }
                }
            }
        }
        return f[1][nums.length];
    }

    public static void main(String[] args) {
        BurstBalloons test = new BurstBalloons();
        int[] nums = {4, 1, 5, 10};
//        int[] nums = {3,4};
        System.out.print(test.maxCoins(nums));
    }
}
