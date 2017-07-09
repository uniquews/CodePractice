import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by shuaiwang on 4/15/17.
 */
public class RussianDollEnvelopesTest {
    @Test
    public void test_longestIncreasingSubSequenceOfHeight() {
        RussianDollEnvelopes test = new RussianDollEnvelopes();

        int[][] input = {{14, 31}, {12, 2}, {29, 16}, {24, 23}, {48, 31}, {17, 11}, {41, 8}, {48, 3}, {36, 14}, {19, 8},
                {49, 47}, {36, 5}, {12, 4}, {11, 35}, {39, 16}, {8, 39}, {15, 29}, {39, 6}, {14, 29}, {34, 46}, {19, 8},
                {23, 37}, {43, 36}, {22, 28}, {48, 24}, {49, 49}, {35, 16}, {13, 19}, {43, 11}, {46, 21}, {46, 42},
                {17, 28}, {3, 15}, {25, 19}, {44, 48}, {8, 4}, {33, 44}, {14, 25}, {7, 10}};
        test.sortEnvelopes(input);
        int[] heights = {15, 10, 39, 4, 35, 4, 2, 19, 31, 29, 25, 29, 28, 11, 8, 8, 28, 37, 23, 19, 16, 44, 46, 16, 14,
                5, 16, 6, 8, 36, 11, 48, 42, 21, 31, 24, 3, 49, 47};
        for (int height : increasingHelper(heights)) {
            System.out.print(height);
            System.out.print(", ");
        }
        List<Integer> result = test.longestIncreasingSubSequenceOfHeight(input);
        assertTrue(result.containsAll(Arrays.asList()));
    }

    private int[] increasingHelper(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return dp;
    }
}
