/**
 * Created by shuaiwang on 5/7/17.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                count = sum[i] - sum[j] == k ? count + 1 : count;
            }
        }
        return count;
    }
}
