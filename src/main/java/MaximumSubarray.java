/**
 * Created by shuaiwang on 10/10/16.
 */
public class MaximumSubarray {

    // Greedy currentSum = Math.max(currentSum, 0);
//    public int maxSubArray(int[] nums) {
//        // write your code
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int result = Integer.MIN_VALUE;
//        int currentSum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            currentSum += nums[i];
//            result = Math.max(result, currentSum);
//            currentSum = Math.max(currentSum, 0);
//        }
//        return result;
//    }

    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int minSum = 0, currentSum = 0, result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            result = Math.max(result, currentSum - minSum);
            minSum = Math.min(minSum, currentSum);
        }
        return result;
    }
}
