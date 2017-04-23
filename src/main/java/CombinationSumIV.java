import java.util.Arrays;

/**
 * Created by shuaiwang on 4/20/17.
 */
public class CombinationSumIV {

    /***
     * 方法1： 记忆化搜索， top to bottom, f[4] = (f[3] + 1) + (f[2] + 2) + (f[1] + 3)
     *
     * f[0] = 1, 因为是dfs，所以 f[1] f[2] f[3] 先被算出来
     *
     * 为什么这道题可以用dp做，因为f[n]和f[n - 1] 是同样的子问题，只是规模不一样
     *
     */

//    public int combinationSum4(int[] nums, int target) {
//        int[] f = new int[target + 1];
//        Arrays.fill(f, -1);
//        return dfs(nums, target, f);
//    }
//
//    private int dfs(int[] nums, int target, int[] f) {
//        if (target == 0) {
//            return 1;
//        }
//
//        if (target < 0) {
//            return 0;
//        }
//
//        if (f[target] != - 1) {
//            return f[target];
//        }
//
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            result += dfs(nums, target - nums[i], f);
//        }
//        f[target] = result;
//        return f[target];
//    }


    /***
     *
     * 用dp bottom up
     *
     */

    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }


    public static void main(String[] args) {
        int[] a = {1,2,3};
        int target = 4;
        CombinationSumIV test = new CombinationSumIV();
        test.combinationSum4(a, target);
    }
}
