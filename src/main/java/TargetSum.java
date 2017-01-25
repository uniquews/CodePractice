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


    /**
     * Way 2 DP
     *
     */

//    public int findTargetSumWays(int[] nums, int S) {
//
//    }
}
