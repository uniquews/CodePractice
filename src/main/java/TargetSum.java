import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 1/23/17.
 */
public class TargetSum {

    // Way 1: dfs:
//    private int result = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        dfs(nums, S, 0, 0);
//        return result;
//    }
//
//    private void dfs(int[] nums, int S, int index, int sum) {
//        if (index == nums.length && sum == S) {
//            result++;
//            return;
//        }
//
//        if (index == nums.length) { // 不是 if (index == nums.length || S == current) 因为index没有到底 即使S == current 后面有可能是sum = 0， 也要算上
//            return;
//        }
//
//        dfs(nums, S, index + 1, sum + nums[index]);
//        dfs(nums, S, index + 1, sum - nums[index]);
//    }


    // subset
//    private int count = 0;
//    private int[] preSum;
//    public int findTargetSumWays(int[] nums, int S) {
//        preSum = new int[nums.length + 1];
//        for (int i = 1; i <= nums.length; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//        dfs(nums, S, 0, 0);
//        return count;
//    }
//
//    private void dfs(int[] nums, int S, int index, int cur) {
//        int minusAfter = preSum[nums.length] - preSum[index];
//        if (cur - minusAfter == S) {
//            count++;
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            int minus = preSum[i] - preSum[index];
//            dfs(nums, S, i + 1, cur - minus + nums[i]);
//        }
//    }

    // 记忆化搜索
    private Map<String, Integer> map;

    public int findTargetSumWays(int[] nums, int S) {
        map = new HashMap<>();
        return dfs(nums, 0, S);
    }

    private int dfs(int[] nums, int index, int target) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        String key = getKey(index, target);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result = 0;
        result += dfs(nums, index + 1, target - nums[index]);
        result += dfs(nums, index + 1, target + nums[index]);
        map.put(key, result);
        return result;
    }

    private String getKey(int index, int target) {
        return String.valueOf(index) + ":" + String.valueOf(target);
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int S = 1;
        TargetSum test = new TargetSum();
        test.findTargetSumWays(nums, S);
    }
}
