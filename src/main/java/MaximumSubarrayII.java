import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 10/16/16.
 */
public class MaximumSubarrayII {
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int[] leftMax = new int[nums.size()];
        int[] rightMax = new int[nums.size()];

        int sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int currentSum = nums.get(i);
            if (sum >= 0) {
                currentSum += sum;
            }
            sum = currentSum;
            leftMax[i] = Math.max(maxVal, currentSum);
            maxVal = Math.max(maxVal, currentSum);
        }

        sum = 0;
        maxVal = Integer.MIN_VALUE;

        for (int i = nums.size() - 1; i >= 0; i--) {
            int currentSum = nums.get(i);
            if (sum >= 0) {
                currentSum += sum;
            }
            sum = currentSum;
            rightMax[i] = Math.max(maxVal, currentSum);
            maxVal = Math.max(maxVal, currentSum);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            result = Math.max(result, leftMax[i] + rightMax[i + 1]);
        }
        return result;
    }
}
