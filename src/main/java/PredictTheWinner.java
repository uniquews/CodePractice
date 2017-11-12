/**
 * Created by shuaiwang on 4/27/17.
 */
public class PredictTheWinner {
//    public boolean PredictTheWinner(int[] nums) {
//        int[] sum = new int[nums.length + 1];
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//
//        int[][] f = new int[nums.length][nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            f[i][i] = nums[i];
//        }
//
//        for (int len = 2; len <= nums.length; len++) {
//            for (int i = 0; i + len - 1 < nums.length; i++) {
//                int j = i + len - 1;
//                f[i][j] = (sum[j + 1] - sum[i]) - Math.min(f[i + 1][j], f[i][j - 1]);
//            }
//        }
//
//        return f[0][nums.length - 1] >= sum[nums.length] - f[0][nums.length - 1];
//    }
    public boolean PredictTheWinner(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int[][] f = new int[nums.length][nums.length];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = -1;
            }
        }

        int result = helper(nums, 0, nums.length - 1, sum, f);
        return result >= sum[nums.length] - result;
    }

    private int helper(int[] nums, int start, int end, int[] sum, int[][] f) {
        if (start == end) {
            return nums[start];
        }

        if (f[start][end] != -1) {
            return f[start][end];
        }

        int tmp1 = helper(nums, start + 1, end, sum, f);
        int tmp2 = helper(nums, start, end - 1, sum, f);

        f[start][end] = sum[end + 1] - sum[start] - Math.min(tmp1, tmp2);

        return sum[end + 1] - sum[start] - Math.min(tmp1, tmp2);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 233, 7};
        int[] nums = {1, 3, 1};
        PredictTheWinner test = new PredictTheWinner();
        test.PredictTheWinner(nums);
    }
}
