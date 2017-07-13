import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuaiwang on 7/12/17.
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> usedString = new HashSet<>();
        return helper(str, 0, pattern, 0, map, usedString);
    }

    private boolean helper(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> usedString) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        }

        if (i == str.length() || j == pattern.length())
            return false;

        char p = pattern.charAt(j);

        if (map.containsKey(p)) {
            String targetStr = map.get(p);

            if (!str.startsWith(targetStr, i)) {
                return false;
            }

            return helper(str, i + targetStr.length(), pattern, j + 1, map, usedString);
        }

        for (int k = i; k < str.length(); k++) {
            String s = str.substring(i, k + 1);

            if (usedString.contains(s)) {
                continue;
            }

            map.put(p, s);
            usedString.add(s);

            if (helper(str, i + s.length(), pattern, j + 1, map, usedString)) {
                return true;
            }
            map.remove(p);
            usedString.remove(s);
        }
        return false;
    }
}
