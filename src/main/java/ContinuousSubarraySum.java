import java.util.ArrayList;

/**
 * Created by shuaiwang on 1/3/17.
 */
public class ContinuousSubarraySum {
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here

        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        int len = A.length;
        int[] sum = new int[len + 1];

        int minSum = 0;
        int minIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + A[i - 1];

            if (sum[i] - minSum > maxSum) {
                maxSum = sum[i] - minSum;
                result.set(0, minIndex); // takes care two cases: 1. [-3, 1, 3, -3, 4], which is normal case   2. [1, -1]
                result.set(1, i - 1);
            }

            if (sum[i] < minSum) {
                minSum = sum[i];
                minIndex = i;
            }
        }

        return result;
    }
}
