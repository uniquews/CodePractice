import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 12/13/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int result = 0;
        if (s == null || s.length() == 0 || k == 0) {
            return result;
        }


        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0, count = 0;
        for (; left < s.length(); left++) {
            while (right < s.length()) {
                if (hashMap.containsKey(s.charAt(right))) {
                    hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) + 1);
                } else {
                    if (count == k) {
                        break;
                    }
                    hashMap.put(s.charAt(right), 1);
                    count++;
                }
                right++;
            }

            result = Math.max(result, right - left);

            hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
            if (hashMap.get(s.charAt(left)) == 0) {
                hashMap.remove(s.charAt(left));
                count--;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        LongestSubstringwithAtMostKDistinctCharacters test = new LongestSubstringwithAtMostKDistinctCharacters();
//        String a = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";  // 9 -> 36 j -> g
        String a = "eceba";  // 9 -> 36 j -> g
//        System.out.print(a.length());
        int k = 3;
        test.lengthOfLongestSubstringKDistinct(a, k);
    }
}
