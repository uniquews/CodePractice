/**
 * Created by shuaiwang on 8/30/16.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // write your code here
        int[][] f = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                f[i][j] = f[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[S.length()][T.length()];
    }
}
