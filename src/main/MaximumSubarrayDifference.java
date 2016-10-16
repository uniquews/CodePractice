package main;

/**
 * Created by shuaiwang on 10/15/16.
 *
 * Given an array with integers.
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
 * Return the largest difference.
 *
 * leftMax[i] is max subarray sum at index i, where nums[i] is added with numbers with index less than i
 * rightMax[i] is max subarray sum at index i, where nums[i] is added with numbers with index greater than i
 * leftMin[i] is min subarray sum at index i, where nums[i] is added with numbers with index less than i
 * rightMin[i] is min subarray sum at index i, where nums[i] is added with numbers with index greater than i;
 *
 * input = [1, 2, -3, 1]
 *
 * leftMax = [1, 3, 3, 3]
 * rightMax = [1, 1, 2, 3]
 * leftMin = [1, 1, -3, -3]
 * rightMin = [1, -3, -3, -3]
 *
 * |SUM(A) - SUM(B)| could be the max subarray, which summed up at left side minus min subarray, which summed up at
 * right side, and vice versa.
 *
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

        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = -1 * nums[i];
        }

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
        for (int i = nums.length - 1; i >= 0 ; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMax[i] = max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            leftMin[i] = -1 * max;
        }

        max = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            rightMin[i] = -1 * max;
        }

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMin[i + 1]));
            result = Math.max(result, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return result;
    }
}
