import java.util.Arrays;

/**
 * Created by shuaiwang on 8/29/16.
 */
public class LongestIncreasingSubsequence {

//    public int longestIncreasingSubsequence(int[] nums) {
//        // write your code here
//        if (nums.length == 0)
//        {
//            return 0;
//        }
//
//        int[] f = new int[nums.length];
//        Arrays.fill(f, 1);
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            for (int j = 0; j < i; j++)
//            {
//                if (nums[i] > nums[j])
//                {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//        }
//
//        int result = 1;
//        for (int i = 0; i < nums.length; i++)
//        {
//            result = Math.max(result, f[i]);
//        }
//
//        return f[nums.length - 1];
//    }

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }
}
