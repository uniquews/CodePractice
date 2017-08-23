import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 12/13/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int right = 0, result = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right - left);
            set.remove(s.charAt(left));
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        String a = "an++--viaj";
        System.out.print(test.lengthOfLongestSubstring(a));
    }
}
