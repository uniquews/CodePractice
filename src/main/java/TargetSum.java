/**
 * Created by shuaiwang on 1/23/17.
 */
public class TargetSum {

    // Way 1: dfs:
    private int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return result;
    }

    private void dfs(int[] nums, int S, int index, int sum) {
        if (index == nums.length && sum == S) {
            result++;
            return;
        }

        if (index == nums.length) { // 不是 if (index == nums.length || S == current) 因为index没有到底 即使S == current 后面有可能是sum = 0， 也要算上
            return;
        }

        dfs(nums, S, index + 1, sum + nums[index]);
        dfs(nums, S, index + 1, sum - nums[index]);
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int S = 1;
        TargetSum test = new TargetSum();
        test.findTargetSumWays(nums, S);
    }
}
