package b;

import java.util.*;

/**
 * Created by bohan on 7/11/17.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<String, List<Integer>> stringMap = parseString(strs);
        Map<Character, List<Integer>> patternMap = parsePattern(pattern);
        for (int i = 0; i < pattern.length(); i++) {
            String s = strs[i];
            char c = pattern.charAt(i);
            if (!Objects.deepEquals(stringMap.get(s), patternMap.get(c))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, List<Integer>> parsePattern(String pattern) {
        Map<Character, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            List<Integer> indexList = res.getOrDefault(c, new ArrayList<>());
            indexList.add(i);
            res.put(c, indexList);
        }
        return res;
    }

    private Map<String, List<Integer>> parseString(String[] strs) {
        Map<String, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<Integer> indexList = res.getOrDefault(strs[i], new ArrayList<>());
            indexList.add(i);
            res.put(strs[i], indexList);
        }
        return res;
    }
}
