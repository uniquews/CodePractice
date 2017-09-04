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
        boolean[] f = new boolean[s.length() + 1];

        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }

        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 1; j--) {
                String str = s.substring(j - 1, i);
                if (set.contains(str) && f[j - 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        String s = "ab";
        List<String> dict = new ArrayList<>(Arrays.asList("a","b"));
        WordBreak test = new WordBreak();
        test.wordBreak(s, dict);
    }
}
