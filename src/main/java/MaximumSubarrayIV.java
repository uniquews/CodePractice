/**
 * Created by shuaiwang on 6/5/17.
 */
public class MaximumSubarrayIV {
    public int maxSubarray4(int[] nums, int k) {
        // Write your code here
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int result = Integer.MIN_VALUE;
        int minSum = 0;
        for (int i = k; i <= nums.length; i++) {
            result = Math.max(result, sum[i] - minSum);
            minSum = Math.min(minSum, i - k + 1);
        }
        return result;
    }
}
