/**
 * Created by shuaiwang on 8/31/16.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int[][] f = new int[A.length() + 1][B.length() + 1];

        f[0][0] = 0;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1; //  LCS(i - 1, j) <= 1 + LCS(i - 1, j - 1)
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[A.length()][B.length()];

    }
}
