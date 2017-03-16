import java.util.HashMap;

/**
 * Created by shuaiwang on 3/15/17.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0, maxLen = 1;
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length()) {
                if (map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                    end++;
                } else if (map.keySet().size() < 2) {
                    map.put(s.charAt(end), 1);
                    end++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, end - start);
            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            if (map.get(s.charAt(start)) == 0) {
                map.remove(s.charAt(start));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "bacc";
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
        System.out.print(test.lengthOfLongestSubstringTwoDistinct(s));
    }
}
