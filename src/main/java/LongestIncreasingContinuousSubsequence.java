import java.util.Arrays;

/**
 * Created by shuaiwang on 12/17/16.
 */
public class LongestIncreasingContinuousSubsequence {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] ins = new int[A.length];
        int[] dis = new int[A.length];

        Arrays.fill(ins, 1);
        Arrays.fill(dis, 1);

        int maxIns = 1;
        int maxDis = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                ins[i]  = ins[i - 1] + 1;
                maxIns = Math.max(maxIns, ins[i]);
            } else if (A[i] < A[i - 1]) {
                dis[i] = dis[i - 1] + 1;
                maxDis = Math.max(maxDis, dis[i]);
            }
        }
        return maxDis > maxIns ? maxDis : maxIns;
    }
}
