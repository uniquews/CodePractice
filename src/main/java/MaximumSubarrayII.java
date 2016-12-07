import java.util.ArrayList;

/**
 * Created by shuaiwang on 10/16/16.
 */
public class MaximumSubarrayII {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int[] leftMax = new int[nums.size()];
        int[] rightMax = new int[nums.size()];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            result = Math.max(result, leftMax[i] + rightMax[i + 1]);
        }
        return result;
    }
}
