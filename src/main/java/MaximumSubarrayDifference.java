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
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int[] leftMin = new int[nums.length];
        int[] rightMin = new int[nums.length];

        int sum = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (sum >= 0) {
                current += sum;
            }
            sum = current;
            leftMax[i] = Math.max(maxVal, current);
            maxVal = Math.max(maxVal, current);
        }

        sum = 0;
        maxVal = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            if (sum >= 0) {
                current += sum;
            }
            sum = current;
            rightMax[i] = Math.max(maxVal, current);
            maxVal = Math.max(maxVal, current);
        }

        sum = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (sum <= 0) {
                current += sum;
            }
            sum = current;
            leftMin[i] = Math.min(minVal, current);
            minVal = Math.min(minVal, current);
        }

        sum = 0;
        minVal = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            if (sum <= 0) {
                current += sum;
            }
            sum = current;
            rightMin[i] = Math.min(minVal, current);
            minVal = Math.min(minVal, current);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMin[i + 1]));
            result = Math.max(result, Math.abs(rightMax[i + 1] - leftMin[i]));
        }
        return result;
    }
}
