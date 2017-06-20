/**
 * Created by shuaiwang on 10/12/16.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];

        int result = currentMax;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                currentMax = Math.max(currentMax * nums[i], nums[i]);
                currentMin = Math.min(currentMin * nums[i], nums[i]);
            } else {
                int prevMax = currentMax;
                currentMax = Math.max(currentMin * nums[i], nums[i]);
                currentMin = Math.min(prevMax * nums[i], nums[i]);
            }
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
