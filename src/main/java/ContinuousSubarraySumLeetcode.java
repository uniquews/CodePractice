import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 9/8/17.
 *
 * sum[i] - sum[j] = n * k
 *
 * 把sum[i] % k 和sum[j] % k 之后， 只有当余数相等，才能是n * k  所以map里存的每一个sum % k余数
 */
public class ContinuousSubarraySumLeetcode {
//    public boolean checkSubarraySum(int[] nums, int k) {
//        int sum = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0);
//        for (int i = 1; i <= nums.length; i++) {
//            sum += nums[i - 1];
//            if (k != 0) {
//                sum = sum % k;
//            }
//
//            if (map.containsKey(sum)) {
//                if (i - map.get(sum) >= 2)
//                return true;
//            } else {
//                map.put(sum, i);  // 多个0 就不要覆盖前面的值，index越小越对
//            }
//        }
//        return false;
//    }


    // k == 0 不能%  所有整数的sum不是0的倍数但是【0，0，0】仍然是0 的倍数
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int[] preSum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int tmp = k == 0 ? preSum[i] : preSum[i] % k;
            if (!map.containsKey(tmp)) {
                map.put(tmp, i);
            } else {
                int prev = map.get(tmp);
                if (i - prev >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySumLeetcode test = new ContinuousSubarraySumLeetcode();
        int[] nums = {0,0};
        int k = 0;
        test.checkSubarraySum(nums, k);
    }
}
