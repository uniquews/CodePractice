/**
 * Created by shuaiwang on 2/9/17.
 */
public class WindowSum {
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            if (i == 0) {
                result[0] = nums[0];
                for (int j = 1; j < k; j++) {
                    result[0] += nums[j];
                }
            } else {
                result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
            }
        }
        return result;
    }
}
