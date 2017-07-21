/**
 * Created by shuaiwang on 5/7/17.
 */
public class EncodeStringWithShortestLength {
//    public String encode(String s) {
//        String[][] dp = new String[s.length()][s.length()];
//        for (int l = 1; l <= s.length(); l++) {
//            for (int i = 0; i + l <= s.length(); i++) {
//                int j = i + l - 1;
//                String current = s.substring(i, i + l);
//                if (l < 4) {
//                    dp[i][j] = current;
//                    continue;
//                }
//                dp[i][j] = current; //这个算是初始化。。。否则下一行的dp[i][j]会报空指针
//                for (int k = i; k < j; k++) {
//                    if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
//                        dp[i][j] = dp[i][k] + dp[k + 1][j];
//                    }
//                }
//
//                // string本身能否是一个完整的 repeatStr
//                for (int m = 1; m <= current.length(); m++) {
//                    String pattern = current.substring(0, m);
//                    if (current.length() % pattern.length() == 0 &&
//                            current.replaceAll(pattern, "").length() == 0) {
//                        // 这个地方特别容易写错，不能用Pattern 因为pattern本身有可能是一个被shorten 的string
//                        String tmp = current.length() / pattern.length() + "[" + dp[i][i + m - 1] + "]";
//                        if (tmp.length() < dp[i][j].length()) {
//                            dp[i][j] = tmp;
//                        }
//                    }
//                }
//            }
//        }
//        return dp[0][s.length() - 1];
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

    public static void main(String[] args) {
        String a = "aabcaabcd";
        EncodeStringWithShortestLength test = new EncodeStringWithShortestLength();
        System.out.println(test.encode(a));
    }
}
