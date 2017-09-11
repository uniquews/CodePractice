/**
 * Created by shuaiwang on 9/7/17.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] == nums[i] && nums[index - 1] == nums[i]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}
