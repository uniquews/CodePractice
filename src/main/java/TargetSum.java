/**
 * Created by shuaiwang on 1/23/17.
 */
public class TargetSum {

    // Way 1: dfs:
//    private int result = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        helper(nums, 0, S, 0);
//        return result;
//    }
//
//    private void helper(int[] nums, int index, int S, int currentSum) {
//        if (index == nums.length && currentSum == S) {
//            result++;
//            return;
//        }
//        if (index == nums.length) {
//            return;
//        }
//
//        helper(nums, index + 1, S, currentSum + nums[index]);
//        helper(nums, index + 1, S, currentSum - nums[index]);
//    }


    private int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S, 0);
        return result;
    }

    private void dfs(int[] nums, int index, int S, int current) {
        if (index == nums.length && S == current) {
            result++;
            return;
        }

        if (index == nums.length) // 不是 if (index == nums.length || S == current) 因为index没有到底 即使S == current 后面有可能是sum = 0， 也要算上
            return;

        int inc = current;
        inc += nums[index];
        dfs(nums, index + 1, S, inc);

        int des = current;
        des -= nums[index];
        dfs(nums, index + 1, S, des);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int S = 1;
        TargetSum test = new TargetSum();
        test.findTargetSumWays(nums, S);
    }
}
