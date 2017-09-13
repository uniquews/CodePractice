import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 12/22/16.
 */
public class ScrambleString {

    // Way 1: dfs + memory search
    private Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        // write your code here
        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "#" + s2;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }

        int end = s1.length() - 1;
        boolean result = false;
        for (int i = 0; i < end; i++) {
            String tmp1 = s1.substring(0, i + 1);
            String tmp2 = s2.substring(0, i + 1);
            String tmp3 = s1.substring(i + 1);
            String tmp4 = s2.substring(i + 1);

            result = result || (isScramble(tmp1, tmp2) && isScramble(tmp3, tmp4));

            String tmp5 = s2.substring(end - i);
            String tmp6 = s2.substring(0, end - i);

            result = result || (isScramble(tmp1, tmp5) && isScramble(tmp3, tmp6));
        }
        map.put(key, result);
        return result;
    }

    // Way 2 f[x][y][len] means subString starts with x and subString starts with y are scramble string. Both of them are with length len
    // f[i][j][l] = (f[i][j][k] && f[i + k][j + k][l - k]) || (f[i][j + (l - k)][k] && f[i + k][j][l - k])
//    public boolean isScramble(String s1, String s2) {
//        // Write your code here
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        int len = s1.length();
//
//        boolean[][][] f = new boolean[len][len][len + 1];
//
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
//            }
//        }
//
//        for (int l = 2; l <= len; l++) {
//            for (int i = 0; i < len && i + l <= len; i++) {
//                for (int j = 0; j < len && j + l <= len; j++) {
//                    for (int k = 1; k < l; k++) {
//                        f[i][j][l] = f[i][j][l] || (f[i][j][k] && f[i + k][j + k][l - k]) || (f[i][j + (l - k)][k] && f[i + k][j][l - k]);
//                    }
//                }
//            }
//        }
//        return f[0][0][len];
//    }
}
