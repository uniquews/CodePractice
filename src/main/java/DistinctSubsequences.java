/**
 * Created by shuaiwang on 8/30/16.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }

        int[][] f = new int[T.length() + 1][S.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            f[0][i] = 1;
        }

        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i][j - 1];
                }
            }
        }

        return f[T.length()][S.length()];
    }
}
