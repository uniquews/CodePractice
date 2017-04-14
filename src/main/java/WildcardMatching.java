import java.util.Arrays;

/**
 * Created by shuaiwang on 9/12/16.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // write your code here
        // write your code here
        if (s == null || p == null) {
            return false;
        }

        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];

        for (boolean[] row : f) {
            Arrays.fill(row, false);
        }

        f[0][0] = true;


        /**
         * leetcode新加的test case
         * s = "c" p = "*?*"  f[1][2]需要f[0][1]的结果，然而f[0][1]是false
         *
         * */
        int startIndex = 0;
        while (startIndex < p.length() && p.charAt(startIndex) == '*') {
            for (int i = 0; i <= s.length(); i++) { // i 从0开始试因为*可以匹配empty char
                f[i][startIndex + 1] = true;
            }
            startIndex++;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?') {
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
                }
            }
        }
        return f[s.length()][p.length()];
    }
}
