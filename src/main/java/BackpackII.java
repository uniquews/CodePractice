/**
 * Created by shuaiwang on 9/6/16.
 */

/*
*  add i itmes to the backpack which only has remaining size of s
*
*  f[i][s] = max(f[i - 1][s], f[i - 1][s - A[i - 1]] + V[i - 1]) (if s - A[i - 1] >= 0)
*
* */
public class BackpackII {
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (m == 0 || A == null || V == null || A.length == 0 || V.length == 0) {
            return 0;
        }

        int[] f = new int[m + 1];

        int result = 0;

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0) {
                    f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
                }

                result = Math.max(result, f[j]);
            }
        }

        return result; // f[m]
    }
}
