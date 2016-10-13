package main;

/**
 * Created by shuaiwang on 10/12/16.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxVal = new int[nums.length]; // the max value of the subarray, which is ended at index i
        int[] minVal = new int[nums.length]; // the min value of the subarray, which is ended at index i
        maxVal[0] = nums[0];
        minVal[0] = nums[0];
        int result = maxVal[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxVal[i] = Math.max(nums[i], nums[i] * maxVal[i - 1]); // either multiply with previous numbers or not
                minVal[i] = Math.min(nums[i], nums[i] * minVal[i - 1]);
            } else {
                maxVal[i] = Math.max(nums[i], nums[i] * minVal[i - 1]);
                minVal[i] = Math.min(nums[i], nums[i] * maxVal[i - 1]);
            }
            result = Math.max(result, maxVal[i]);
        }
        return result;
    }
}
