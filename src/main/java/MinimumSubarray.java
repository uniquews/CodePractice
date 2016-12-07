import java.util.ArrayList;

/**
 * Created by shuaiwang on 10/10/16.
 */
public class MinimumSubarray {
//    public int minSubArray(ArrayList<Integer> nums) {
//        // write your code
//        if (nums == null || nums.size() == 0) {
//            return 0;
//        }
//
//        int currentSum = 0, result = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.size(); i++) {
//            currentSum += nums.get(i);
//            result = Math.max(currentSum, result);
//            currentSum = Math.min(0, currentSum);
//        }
//        return result;
//    }

    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int maxSum = 0, result = Integer.MAX_VALUE, currentSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            currentSum += nums.get(i);
            result = Math.min(result, currentSum - maxSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return result;
    }
}
