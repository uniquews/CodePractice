import java.util.*;

/**
 * Created by shuaiwang on 8/30/16.
 */
public class WordBreak {
//    public boolean wordBreak(String s, Set<String> dict) {
//        // write your code here
//        if (s == null) {
//            return false;
//        }
//
//        boolean[] f = new boolean[s.length() + 1];
//        f[0] = true;
//
//        int maxLength = getMaxLength(dict);
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (i - j > maxLength) {
//                    break;
//                }
//                String tmp = s.substring(j, i);
//                f[i] = f[i] || f[j] && dict.contains(tmp);
//            }
//        }
//
//        return f[s.length()];
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return false;
        }

        int maxLength = 0;
        for (String str : wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }

        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String current = s.substring(j, j + i);
                if (wordDict.contains(current)) {
                    f[j][j + i - 1] = true;
                    continue;
                }

                if (i >= 2) {
                    for (int k = 1; k < i; k++) {
                        if (f[j][j + k - 1] && f[j + k][j + i - 1]) {
                            f[j][j + i - 1] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "ab";
        List<String> dict = new ArrayList<>(Arrays.asList("a","b"));
        WordBreak test = new WordBreak();
        test.wordBreak(s, dict);
    }
}
