import java.util.Arrays;

/**
 * Created by shuaiwang on 8/30/16.
 */
public class PalindromePartitioningII {
    // f[i] = f[j] + 1 if  f[j] is not Integer.MAX and s[j + 1][i] is palindrome
    public int minCut(String s) {
        int[] f = new int[s.length() + 1];
        boolean[][] map = new boolean[s.length()][s.length()];

        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = -1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] == Integer.MAX_VALUE || !isValid(map, s, j, i - 1)) {
                    continue;
                }
                f[i] = Math.min(f[j] + 1, f[i]);
            }
        }
        return f[s.length()];
    }

    private boolean isValid(boolean[][] map, String s, int i, int j) {
        if (i == j) {
            map[i][i] = true;
            return true;
        }

        if (i == j - 1) {
            map[i][j] = s.charAt(i) == s.charAt(j);
            return map[i][j];
        }

        map[i][j] = map[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        return map[i][j];
    }
}
