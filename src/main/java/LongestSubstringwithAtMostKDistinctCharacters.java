import java.util.HashMap;

/**
 * Created by shuaiwang on 12/13/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        int start = 0, end = 0, count = 0, maxLen = 0;
        for (; start < s.length(); start++) {
            while (end < s.length()) {
                if (hashMap.containsKey(s.charAt(end))) {
                    hashMap.put(s.charAt(end), hashMap.get(s.charAt(end)) + 1);
                } else {
                    if (count == k) {
                        break;
                    }
                    hashMap.put(s.charAt(end), 1);
                    count++;
                }
                end++;
            }
            maxLen = Math.max(end - start, maxLen);
            hashMap.put(s.charAt(start), hashMap.get(s.charAt(start)) - 1);
            if (hashMap.get(s.charAt(start)) == 0) {
                hashMap.remove(s.charAt(start));
                count--;
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {

        LongestSubstringwithAtMostKDistinctCharacters test = new LongestSubstringwithAtMostKDistinctCharacters();
//        String a = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";  // 9 -> 36 j -> g
//        String a = "eceba";  // 9 -> 36 j -> g
        String a = "abaccc";  // 9 -> 36 j -> g
//        System.out.print(a.length());
        int k = 2;
        System.out.print(test.lengthOfLongestSubstringKDistinct(a, k));
    }
}
