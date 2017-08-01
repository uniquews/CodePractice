/**
 * Created by shuaiwang on 5/8/17.
 */
public class MaximumAverageSubarray {
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double start = Integer.MAX_VALUE;
        double end = Integer.MIN_VALUE;
        for (int i : nums) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }

        while (end - start >= 1e-6) {
            double mid = (start + end) / 2.0;
            if (helper(nums, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private boolean helper(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        double minInPreviousSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] - mid);
            if (i >= k && sum[i] - minInPreviousSum >= 0) {
                return true;
            }
            if (i >= k) {
                minInPreviousSum = Math.min(minInPreviousSum, sum[i - k + 1]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        MaximumAverageSubarray test = new MaximumAverageSubarray();
        test.maxAverage(nums, k);
    }
}
