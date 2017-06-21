/**
 * Created by shuaiwang on 6/19/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int shouldBeSum = (0 + nums.length) * (nums.length + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return shouldBeSum - sum;
    }
}
