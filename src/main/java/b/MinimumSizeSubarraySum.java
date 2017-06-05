package b;

import java.util.Arrays;

/**
 * Created by bohan on 5/15/17.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            int j = Arrays.binarySearch(sums, 0, i + 1, sums[i + 1] - s);
            if (j < 0) {
                j = j * -1 - 2;
            }
            if (j >= 0) {
                minLen = Math.min(minLen, i - j + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
