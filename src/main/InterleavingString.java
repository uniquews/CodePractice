package main;

/**
 * Created by shuaiwang on 8/31/16.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s2.length() == 0) {
            return true;
        }

        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            f[i][0] = s1.charAt(i - 1)== s3.charAt(i - 1);
        }

        for (int j = 1; j <= s2.length(); j++) {
            f[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j -1));
            }
        }

        return f[s1.length()][s2.length()];
    }

}
