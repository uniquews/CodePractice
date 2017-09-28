/**
 * Created by shuaiwang on 6/5/17.
 */
public class MaximumSubarrayIV {
    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sum = new int[nums.length + 1];
        int minVal = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (i >= k) {
                result = Math.max(result, sum[i] - minVal);
                minVal = Math.min(minVal, sum[i - k + 1]);
            }
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
