package b;

/**
 * Created by bohan on 7/16/17.
 */
public class EncodeStringWithShortestLength {
    /**
     * f[i][j] denotes the shortest encoded string from i to j;
     * f[i][j] = minLength(f[i][j], f[i][k] + f[k + 1][j])
     */
//    public String encode(String s) {
//        String[][] f = new String[s.length()][s.length()];
//        for (int l = 0; l < s.length(); l++) {
//            for (int i = 0; i < s.length() - l; i++) {
//                int j = i + l;
//                String substring = s.substring(i, j + 1);
//                f[i][j] = substring;
//                if (l < 4) {
//                    continue;
//                }
//                for (int k = i; k < j; k++) {
//                    if (f[i][j].length() > f[i][k].length() + f[k + 1][j].length()) {
//                        f[i][j] = f[i][k] + f[k + 1][j];
//                    }
//                }
//                // encode pattern.
//                for (int patternLength = 1; patternLength < l; patternLength++) {
//                    String pattern = substring.substring(0, patternLength);
//                    if (substring.length() % patternLength == 0 && substring.replaceAll(pattern, "").length() == 0) {
//                        String num = String.valueOf(substring.length() / patternLength);
//                        pattern = f[i][i + patternLength - 1];
//                        if (num.length() + pattern.length() + 2 >= f[i][j].length()) {
//                            continue;
//                        }
//                        f[i][j] = num + "[" + pattern + "]";
//                    }
//                }
//            }
//        }
//        return f[0][s.length() - 1];
//    }
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j + i <= s.length(); j++) {
                String cur = s.substring(j, j + i);
                if (i <= 4) {
                    dp[j][j + i - 1] = cur;
                    continue;
                } else {
                    dp[j][j + i - 1] = cur;
                    for (int k = j; k < j + i - 1; k++) {
                        if (dp[j][k].length() + dp[k + 1][j + i - 1].length() < dp[j][j + i - 1].length()) {
                            dp[j][j + i - 1] = dp[j][k] + dp[k + 1][j + i - 1];
                        }
                    }

                    for (int m = 1; m <= cur.length(); m++) {
                        int end = j + m - 1;
                        String pattern = s.substring(j, j + m);
                        if (cur.length() % pattern.length() == 0 && cur.replaceAll(pattern, "").length() == 0) {
                            String ss = String.valueOf(cur.length() / pattern.length()) + "[" + dp[j][end] + "]";
                            if (ss.length() < dp[j][j + i - 1].length()) {
                                dp[j][j + i - 1] = ss;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
