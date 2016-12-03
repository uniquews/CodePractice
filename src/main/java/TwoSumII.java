import java.util.Arrays;

/**
 * Created by shuaiwang on 11/21/16.
 */
public class TwoSumII {
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int result = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                result += end - start;
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
