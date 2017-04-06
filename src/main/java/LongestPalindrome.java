import java.util.HashMap;

/**
 * Created by shuaiwang on 4/5/17.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int maxOdd = 0;
        for (Integer num : map.values()) {
            if (num % 2 != 0) {
                maxOdd = Math.max(maxOdd, num);
            }
        }

        int result = 0;
        for (Integer num : map.values()) {
            if (num % 2 == 0) {
                result += num;
            } else {
                if (maxOdd == num) {
                    result += num;
                    maxOdd = -1;
                } else {
                    result += num - 1;
                }
            }
        }
        return result;
    }
}
