import java.util.*;

/**
 * Created by shuaiwang on 2/21/17.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int maxLen = 1;
        int maxIndex = 0;
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    parent[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }

            if (maxLen < dp[i]) {
                maxIndex = i;
                maxLen = dp[i];
            }
        }

        int i = maxIndex;
        while (i != -1) {
            result.add(0, nums[i]);
            i = parent[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        test.largestDivisibleSubset(nums);
    }
}
