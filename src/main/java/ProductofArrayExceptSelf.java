/**
 * Created by shuaiwang on 1/22/17.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length + 1];
        result[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = result[i - 1] * nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            result[i] = result[i - 1] * right;
            right = right * nums[i];
        }
        result[0] = right;
        return result;
    }
}
