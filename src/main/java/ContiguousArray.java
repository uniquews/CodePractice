import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/20/17.
 */
public class ContiguousArray {

    // TLE
//    public int findMaxLength(int[] nums) {
//        int[] sum = new int[nums.length];
//        for (int i = 1; i <= nums.length; i++) {
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//
//        int result = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if ((i - j) % 2 != 0) {
//                    continue;
//                }
//
//                if ((sum[i] - sum[j]) == (i - j) / 2) {
//                    result = Math.max(result, i - j);
//                }
//            }
//        }
//        return result;
//    }

    // 和max subarray average 一个思路，把0初始化成-1就是为了让potential average等于0
//    public int findMaxLength(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0)
//                nums[i] = -1;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum = 0, result = 0;
//        map.put(0,0);
//        for (int i = 1; i <= nums.length; i++) {
//            sum += nums[i - 1];
//            if (map.containsKey(sum)) {
//                result = Math.max(result, i - map.get(sum));
//            } else {
//                map.put(sum, i);
//            }
//        }
//        return result;
//    }
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(preSum[i])) {
                ans = Math.max(ans, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        ContiguousArray test = new ContiguousArray();
        test.findMaxLength(nums);
    }
}
