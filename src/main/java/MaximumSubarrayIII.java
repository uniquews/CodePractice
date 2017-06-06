/**
 * Created by shuaiwang on 10/17/16.
 DP. d[i][j] means the maximum sum we can get by selecting j subarrays from the first i elements.

 d[i][j] = max{d[p][j-1]+maxSubArray(p+1,i)}

 we iterate p from i-1 to j-1, so we can record the max subarray we get at current p, this value can be used to calculate the max subarray from p-1 to i when p becomes p-1.
 */
public class MaximumSubarrayIII {

    //没有优化的版本 O(n^3 * k)
//    public int maxSubArray(int[] nums, int k) {
//        // write your code here
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int[][] f = new int[nums.length + 1][k + 1];
//        for (int j = 1; j <= k; j++) {
//            for (int i = j; i <= nums.length; i++) {
//                f[i][j] = Integer.MIN_VALUE;
//                for (int p = j - 1; p <= i - 1; p++) { // j - 1是p在最左边 满足前j - 1的subarray   i - 1是p在最右边满足p + 1 == i  第i个数是滴j个subarray
//                    f[i][j] = Math.max(f[i][j], f[p][j - 1] + maxSubArray(nums, p + 1, i));
//                }
//            }
//        }
//        return f[nums.length][k];
//    }
//
//    private int maxSubArray(int[] nums, int start, int end) {
//        start = start - 1;
//        end = end - 1;
//
//        int sum = 0;
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = start; i <= end; i++) {
//            if (sum >= 0) {
//                sum = nums[i] + sum;
//            } else {
//                sum = nums[i];
//            }
//            maxSum = Math.max(maxSum, sum);
//        }
//        return maxSum;
//    }

    //优化过的版本 O(n^2 * k)
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] f = new int[nums.length + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = j; i <= nums.length; i++) {
                f[i][j] = Integer.MIN_VALUE;

                int sum = 0;
                int maxSum = Integer.MIN_VALUE;
                for (int p = i - 1; p >= j - 1; p--) { // j - 1是p在最左边 满足前j - 1的subarray   i - 1是p在最右边满足p + 1 == i  第i个数是滴j个subarray
                    if (sum >= 0) {
                        sum += nums[p];
                    } else {
                        sum = nums[p];
                    }
                    maxSum = Math.max(maxSum, sum);

                    f[i][j] = Math.max(f[i][j], f[p][j - 1] + maxSum);
                }
            }
        }
        return f[nums.length][k];
    }
}
