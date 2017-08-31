import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (map.containsKey(sum[i] - k)) {
                result = Math.max(result, i - map.get(sum[i] - k));
            }
            if (map.containsKey(sum[i])) {
                continue;
            }
            map.put(sum[i], i);
        }
        return result;
    }
}
