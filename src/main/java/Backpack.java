/**
 * Created by shuaiwang on 9/7/16.
 */

/*
*  add i itmes to the backpack which only has remaining size of s
*
*  f[i][s] = max(f[i - 1][s], f[i - 1][s - A[i - 1]] + A[i - 1]) (if s - A[i - 1] >= 0)
*
* */

public class Backpack {
    public int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }

        int[] f = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= 0; j--) {
                int tmp = j - A[i];
                if (j - A[i] >= 0) {
                    f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
                }
            }
        }
        return f[m];
    }
}
