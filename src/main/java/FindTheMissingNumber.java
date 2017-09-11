/**
 * Created by shuaiwang on 9/11/17.
 */
public class FindTheMissingNumber {
    public int findMissing(int[] nums) {
        // write your code here
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums.length) {
                swap(nums, nums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
