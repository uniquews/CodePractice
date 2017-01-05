import java.util.ArrayList;

/**
 * Created by shuaiwang on 1/3/17.
 */
public class ContinuousSubarraySumII {
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList();
        if (A == null || A.length == 0) {
            return result;
        }

        int len = A.length;
        int[] sum = new int[len + 1];
        int[] specialSum = new int[len + 1];

        int maxSumFromStart = 0;
        int minSumFromStart = 0;
        int maxIndexLeft = 0;
        int maxIndexRight = 1;
        int maxIndexLeftDirty = 0;
        int minIndexLeft = 1;
        int minIndexRight = 2;
        int minIndexLeftDirty = 1;
        int maxSubArraySum = Integer.MIN_VALUE;
        int minSubArraySum = Integer.MAX_VALUE;

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            if (maxSubArraySum < sum[i] - minSumFromStart) {
                maxSubArraySum = sum[i] - minSumFromStart;
                maxIndexRight = i;
                maxIndexLeft = maxIndexLeftDirty;
            }

            if (minSumFromStart > sum[i]) {
                minSumFromStart = sum[i];
                maxIndexLeftDirty = i;
            }

            if (i >= 2 && i < len) {
                specialSum[i] = specialSum[i - 1] + A[i - 1];
                if (minSubArraySum > specialSum[i] - maxSumFromStart) {
                    minSubArraySum = specialSum[i] - maxSumFromStart;
                    minIndexRight = i;
                    minIndexLeft = minIndexLeftDirty;
                }

                if (maxSumFromStart < specialSum[i]) {
                    maxSumFromStart = specialSum[i];
                    minIndexLeftDirty = i;
                }
            }
        }

        if (maxSubArraySum > sum[len] - minSubArraySum) {
            result.add(maxIndexLeft);
            result.add(maxIndexRight - 1);
        } else {
            result.add(minIndexRight);
            result.add(minIndexLeft - 1);
        }
        return result;
    }
}
