/**
 * Created by shuaiwang on 5/19/17.
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 2; i <= nums.length; i++) {
            for (int j = 0; j <= i - 2; j++) {
                if (k == 0) {
                    if (sum[i] - sum[j] == 0)
                        return true;
                } else {
                    if ((sum[i] - sum[j]) % k == 0)
                        return true;
                }
            }
        }
        return false;
    }
}
