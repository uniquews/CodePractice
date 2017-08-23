import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 8/22/17.
 */

// wiil tle....
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int num = words.length, len = words[0].length();
        for (int i = 0; i <= s.length() - num * len; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < num; j++) {
                String current = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(current)) {
                    copy.put(current, copy.get(current) - 1);
                    if (copy.get(current) == 0)
                        copy.remove(current);
                }
            }
            if (copy.size() == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] a = {"foo","bar"};
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        test.findSubstring(s, a);
    }
}
