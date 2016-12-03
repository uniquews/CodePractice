import java.util.Arrays;

/**
 * Created by shuaiwang on 9/30/16.
 */
public class TwoSumClosest {
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        int gap = Integer.MAX_VALUE;

        while (i < j) {
            int tmp = nums[i] + nums[j];
            gap = Math.min(gap, Math.abs(tmp - target));

            if (tmp > target) {
                j--;
            } else if (tmp < target) {
                i++;
            } else {
                return gap;
            }
        }
        return gap;
    }
}
