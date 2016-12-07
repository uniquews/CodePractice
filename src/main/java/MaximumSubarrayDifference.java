/**
 * Created by shuaiwang on 10/15/16.
 * <p>
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 * <p>
 * leftMax[i] is max subarray sum at index i, where nums[i] is added with numbers with index less than i
 * rightMax[i] is max subarray sum at index i, where nums[i] is added with numbers with index greater than i
 * leftMin[i] is min subarray sum at index i, where nums[i] is added with numbers with index less than i
 * rightMin[i] is min subarray sum at index i, where nums[i] is added with numbers with index greater than i;
 * <p>
 * input = [1, 2, -3, 1]
 * <p>
 * leftMax = [1, 3, 3, 3]
 * rightMax = [1, 1, 2, 3]
 * leftMin = [1, 1, -3, -3]
 * rightMin = [1, -3, -3, -3]
 * <p>
 * |SUM(A) - SUM(B)| could be the max subarray, which summed up at left side minus min subarray, which summed up at
 * right side, and vice versa.
 */
public class MaximumSubarrayDifference {
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];

        int max = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }

        int min = Integer.MAX_VALUE;
        int maxSum = 0;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            leftMin[i] = min;
        }

        min = Integer.MAX_VALUE;
        maxSum = 0;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            rightMin[i] = min;
        }

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMin[i + 1]));
            result = Math.max(result, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return result;
    }
}
