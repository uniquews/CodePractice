import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> numOfSum = new HashMap<>();

        numOfSum.put(0, 1);

        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (numOfSum.containsKey(sum - k)) {
                result += numOfSum.get(sum - k);
            }
            int occur = numOfSum.getOrDefault(sum, 0) + 1;
            numOfSum.put(sum, occur);
        }
        return result;
    }
}
