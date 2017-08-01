/**
 * Created by shuaiwang on 7/31/17.
 */
public class MaximumAveragySubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int [nums.length + 1];

        int maxSubArraySum = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (i - k >= 0) {
                maxSubArraySum = Math.max(maxSubArraySum, sum[i] - sum[i - k]);
            }
        }
        return 1.0 * maxSubArraySum / k;
    }
}
