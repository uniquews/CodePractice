import java.util.HashSet;

/**
 * Created by shuaiwang on 12/13/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        HashSet hashSet = new HashSet<>();

        int left = 0;
        int right = left;
        for (; left < s.length(); left++) {
            while (right < s.length() && !hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++;
            }

            result = Math.max(result, right - left);

            if (right < s.length()) {
                char dup = s.charAt(right);

                while (s.charAt(left) != dup) {
                    hashSet.remove(s.charAt(left));
                    left++;
                }
                hashSet.remove(s.charAt(right));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        String a = "an++--viaj";
        System.out.print(test.lengthOfLongestSubstring(a));
    }
}
