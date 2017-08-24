/**
 * Created by shuaiwang on 12/13/16.\
 */


public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int right = 0, sum = 0, result = Integer.MAX_VALUE;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            if (sum >= s)
                result = Math.min(result, right - left);
            sum -= nums[left];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
