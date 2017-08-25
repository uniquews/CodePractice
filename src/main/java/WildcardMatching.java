import java.util.Arrays;

/**
 * Created by shuaiwang on 9/12/16.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                f[0][i] = f[0][i - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1]; // (i-1,j): s=aaaa p=a*   (i, j- 1): s=a p=a*
                }
            }
        }
        return f[s.length()][p.length()];
    }
}
