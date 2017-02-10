/**
 * Created by shuaiwang on 2/9/17.
 */
public class TwoSumIVInputArrayIsSorted {
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
