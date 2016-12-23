import java.util.HashMap;

/**
 * Created by shuaiwang on 12/22/16.
 */
public class ScrambleString {

    // Way 1: dfs + memory search
    HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if (hashMap.containsKey(s1 + "#" + s2)) {
            return hashMap.get(s1 + "#" + s2);
        }

        if (s1.length() != s2.length()) {
            hashMap.put(s1 + "#" + s2, false);
            return false;
        }

        if (s1.length() == 1) {
            hashMap.put(s1 + "#" + 2, s1.charAt(0) == s2.charAt(0));
            return s1.charAt(0) == s2.charAt(0);
        }

        int len = s1.length();

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, len), s2.substring(i, len))
                || isScramble(s1.substring(0, i), s2.substring(len - i, len)) && isScramble(s1.substring(i, len), s2.substring(0, len - i))) {
                hashMap.put(s1 + "#" + s2, true);
                return true;
            }
        }

        hashMap.put(s1 + "#" + 2, false);
        return false;
    }
}
