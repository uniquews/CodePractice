/**
 * Created by shuaiwang on 12/22/16.
 */
public class ScrambleString {

    // Way 1: dfs + memory search
//    HashMap<String, Boolean> hashMap = new HashMap<>();
//
//    public boolean isScramble(String s1, String s2) {
//        // Write your code here
//        if (hashMap.containsKey(s1 + "#" + s2)) {
//            return hashMap.get(s1 + "#" + s2);
//        }
//
//        if (s1.length() != s2.length()) {
//            hashMap.put(s1 + "#" + s2, false);
//            return false;
//        }
//
//        if (s1.length() == 1) {
//            hashMap.put(s1 + "#" + 2, s1.charAt(0) == s2.charAt(0));
//            return s1.charAt(0) == s2.charAt(0);
//        }
//
//        int len = s1.length();
//
//        for (int i = 1; i < s1.length(); i++) {
//            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))
//                    || isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
//                hashMap.put(s1 + "#" + s2, true);
//                return true;
//            }
//        }
//
//        hashMap.put(s1 + "#" + 2, false);
//        return false;
//    }

    // Way 2 f[x][y][len] means subString starts with x and subString starts with y are scramble string. Both of them are with length len
    // f[i][j][l] = (f[i][j][k] && f[i + k][j + k][l - k]) || (f[i][j + (l - k)][k] && f[i + k][j][l - k])
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();

        boolean[][][] f = new boolean[len][len][len + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len && i + l <= len; i++) {
                for (int j = 0; j < len && j + l <= len; j++) {
                    for (int k = 1; k < l; k++) {
                        f[i][j][l] = f[i][j][l] || (f[i][j][k] && f[i + k][j + k][l - k]) || (f[i][j + (l - k)][k] && f[i + k][j][l - k]);
                    }
                }
            }
        }
        return f[0][0][len];
    }
}
