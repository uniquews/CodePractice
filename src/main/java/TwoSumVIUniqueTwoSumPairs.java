import java.util.Arrays;

/**
 * Created by shuaiwang on 2/9/17.
 */
public class TwoSumVIUniqueTwoSumPairs {
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        int result = 0, left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result++;
                while (left + 1 < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
