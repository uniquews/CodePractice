/**
 * Created by shuaiwang on 7/20/17.
 */
public class RegularExpressionMatching {

    /*
    *
    * 1.if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
      2.if p.charAt(j-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty


             dp[i][j] = dp[i-1][j]  test case: s = "aaa", p = ".*"
    * */
//    public boolean isMatch(String s, String p) {
//        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
//
//        //如果s为空但是p不为空，f[0][i]还有可能是true
//        //如果s不为空但是p为空，f[i][0]肯定是false，所以不需要初始化
//        //为了后面引用 f[0][0]需要是true
//
//        f[0][0] = true;
//        for (int i = 1; i <= p.length(); i++) {
//            if (p.charAt(i - 1) == '*') {
//                if (i == 1) {
//                    f[0][i] = true;
//                } else {
//                    f[0][i] = f[0][i - 2];
//                }
//            }
//        }
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 1; j <= p.length(); j++) {
//                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
//                    f[i][j] = f[i - 1][j - 1];
//                } else if (p.charAt(j - 1) == '*') {
//                    f[i][j] = f[i][j - 1];
//                    if (j >= 2) {
//                        f[i][j] = f[i][j] || f[i][j - 2];
//                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
//                            // s = ab p = d* inorder to let i-1 match j, you have to make sure
//                            // that s.char(i - 1) == p.charAt(j-2) Otherwise in this case,
//                            // we will let a match d*, which gets true without checking if a == b
//                            // however ad* should match d*
//                            f[i][j] = f[i][j] || f[i - 1][j];
//                        }
//                    }
//
//                }
//            }
//        }
//        return f[s.length()][p.length()];
//    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (s.isEmpty()) {
            if (p.length() < 2 || p.charAt(1) != '*') {
                return false;
            }
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || !s.isEmpty() && isMatch(s.substring(1), p) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }

        if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
            return !s.isEmpty() && isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = ".*c";
        RegularExpressionMatching test = new RegularExpressionMatching();
        test.isMatch(s, p);
    }
}
