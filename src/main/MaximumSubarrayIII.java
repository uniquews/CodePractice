package main;

/**
 * Created by shuaiwang on 10/17/16.
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
