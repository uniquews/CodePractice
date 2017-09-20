/**
 * Created by shuaiwang on 10/10/16.
 */
public class MaximumSubarray {

    // Greedy currentSum = Math.max(currentSum, 0);
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}
