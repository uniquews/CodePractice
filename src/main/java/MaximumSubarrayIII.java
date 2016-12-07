/**
 * Created by shuaiwang on 10/17/16.
 * <p>
 * f[i][j]: the maximum value of jth subarray ending at ith number. In this case, the ith number would be
 * <p>
 * i. the starting of the jth subarray, which only has one number
 * OR
 * ii. the end of the jth subarray
 * <p>
 * i. f[m][j - 1] + nums[i - 1] where j - 1 <= m <= i - 1  (j - 1)th subarray could be ending at mth number
 * ii. f[i - 1][j] + nums[i - 1] add nums[i - 1] to the end of the jth subarray
 * <p>
 * However, you can't write something like:
 * <p>
 * f[i][j] = Math.max(f[m][j - 1] + nums[i - 1], f[i - 1][j] + nums[i - 1])
 * <p>
 * because for instance,
 * [-1, Integer.MIN_VALUE], 1
 * f[2][1] = Math.max(f[1][0] + nums[1], f[1][1] + nums[1])
 * <p>
 * f[1][1] + nums[1] will be overflow
 */
public class MaximumSubarrayIII {
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] f = new int[nums.length + 1][k + 1];
        for (int i = 0; i <= nums.length; i++) {
            if (i + 1 <= k) {
                f[i][i + 1] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                f[i][j] = f[i - 1][j]; // ith number is added into jth subarray
                for (int m = j - 1; m <= i - 1; m++) {
                    f[i][j] = Math.max(f[i][j], f[m][j - 1]);
                }
                f[i][j] = f[i][j] + nums[i - 1];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = k; i <= nums.length; i++) {
            result = Math.max(result, f[i][k]);
        }
        return result;
    }
}
