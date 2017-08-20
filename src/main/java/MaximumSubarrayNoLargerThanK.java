import java.util.TreeSet;

/**
 * Created by shuaiwang on 4/17/17.
 */
public class MaximumSubarrayNoLargerThanK {
    public int maxSubarrayNoLargerThanK(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        TreeSet<Integer> set = new TreeSet<>();

        int result = Integer.MIN_VALUE;
        set.add(0);
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            Integer firstGreaterOrEqual = set.ceiling(sum[i] - k);
            set.add(sum[i]);
            if (firstGreaterOrEqual == null) {
                continue;
            }
            result = Math.max(result, sum[i] - firstGreaterOrEqual);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,-1};
        MaximumSubarrayNoLargerThanK test = new MaximumSubarrayNoLargerThanK();
        test.maxSubarrayNoLargerThanK(nums, 0);
    }
}
