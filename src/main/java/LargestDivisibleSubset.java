import java.util.*;

/**
 * Created by shuaiwang on 2/21/17.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int maxLen = 1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLen < dp[i]) {
                maxIndex = i;
                maxLen = dp[i];
            }
        }

        List<Integer> result = new ArrayList<>(maxLen);
        result.add(nums[maxIndex]);
        int parentIndex = maxIndex - 1;
        int index = maxIndex;
        while (parentIndex >= 0) {
            if (nums[index] % nums[parentIndex] == 0) {
                result.add(nums[parentIndex]);
                index = parentIndex;
            }
            parentIndex--;
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LargestDivisibleSubset test = new LargestDivisibleSubset();
        test.largestDivisibleSubset(nums);
    }
}
