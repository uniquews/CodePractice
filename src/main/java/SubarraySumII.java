/**
 * Created by shuaiwang on 5/11/17.
 */
public class SubarraySumII {
    public int subarraySumII(int[] A, int start, int end) {
       // Write your code here
        int[] sum = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }

        int result = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] >= start && sum[i] - sum[j] <= end) {
                    result++;
                }
            }
        }
        return result;
    }
}
