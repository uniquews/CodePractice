/**
 * Created by shuaiwang on 12/13/16.\
 */


public class MinimumSizeSubarraySum {
    /**
     * @param nums:   an array of integers
     * @param target: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        boolean found = false;

        int right = 0, sum = 0, result = Integer.MAX_VALUE;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }

            if (sum >= target) {
                found = true;
                result = Math.min(result, right - left);
            }

            sum -= nums[left];
        }

        return found ? result : -1;
    }
}
