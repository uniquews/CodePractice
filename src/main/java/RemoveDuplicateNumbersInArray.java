import java.util.Arrays;

/**
 * Created by shuaiwang on 2/13/17.
 */
public class RemoveDuplicateNumbersInArray {
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
