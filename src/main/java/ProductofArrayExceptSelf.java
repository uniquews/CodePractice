/**
 * Created by shuaiwang on 1/22/17.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] left = new int[nums.length];
        int[] result = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = prev * nums[i];
            prev = left[i];
        }

        result[nums.length - 1] = prev;
        prev = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            result[i] = prev * left[i - 1];
            prev *= nums[i];
        }
        result[0] = prev;
        return result;
    }
}
