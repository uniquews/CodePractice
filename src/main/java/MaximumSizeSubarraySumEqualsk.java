import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class MaximumSizeSubarraySumEqualsk {
//    public int maxSubArrayLen(int[] nums, int k) {
//        int[] sum = new int[nums.length + 1];
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//
//        int maxLen = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (sum[i] - sum[j] == k) {
//                    maxLen = Math.max(maxLen, i - j);
//                }
//            }
//        }
//        return maxLen;
//    }

    // O(n) solution:
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
        return maxLen;
    }
}
