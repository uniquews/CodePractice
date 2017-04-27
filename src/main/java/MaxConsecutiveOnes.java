/**
 * Created by shuaiwang on 4/26/17.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0)
            return result;
        int[] f = new int[nums.length];
        f[0] = nums[0] == 1 ? 1 : 0;
        result = Math.max(result, f[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            f[i] = f[i - 1] + 1;
            result = Math.max(result, f[i]);
        }
        return result;
    }
}
