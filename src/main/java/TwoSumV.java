import java.util.Arrays;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class TwoSumV {
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, result = 0;

        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result += right - left;
                left++;
            }
        }
        return result;
    }
}
