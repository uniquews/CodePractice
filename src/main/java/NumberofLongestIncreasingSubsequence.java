import java.util.Arrays;

/***
 *
 * g[i]表示 以i结尾的LIS的个数 （不一定是global的LIS）
 * g[i] = g[j] if f[i] < f[j] + 1
 * g[i] += g[j] if f[i] = f[j] + 1
 * f[i] > f[j] + 1时不更新g[i] 因为对于j —— i 不是LIS
 *
 * 当f[i] > maxLen时，count = g[i]，此时g[i]是整个数组里LIS的count
 * f[i] == maxLen 时， count += g[i]
 *
 * 初始化count = 0 {2，2，2，2，2} i要从0开始，如果count = nums.length, maxLen = 1,
 * 每次count += 1。。。
 * */

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        Arrays.fill(f, 1);
        Arrays.fill(g, 1);
        int maxLen = 1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }

                if (f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    g[i] = g[j];
                } else if (f[i] == f[j] + 1) {
                    g[i] += g[j];
                }
            }
            if (maxLen < f[i]) {
                maxLen = f[i];
                count = g[i];
            } else if (maxLen == f[i]) {
                count += g[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence test = new NumberofLongestIncreasingSubsequence();
        int[] a = {3,2,1};
        System.out.println(test.findNumberOfLIS(a));
    }
}
