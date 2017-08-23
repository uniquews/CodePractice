import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuaiwang on 12/13/16.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        Set<Character> set = new HashSet<>();
//
//        int right = 0, left = 0, result = 0;
//        for (; right < s.length(); right++) {
//            int num = map.getOrDefault(s.charAt(right), 0) + 1;
//            set.add(s.charAt(right));
//            map.put(s.charAt(right), num);
//
//            while (set.size() > k) {
//                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
//                if (map.get(s.charAt(left)) == 0) {
//                    map.remove(s.charAt(left));
//                    set.remove(s.charAt(left));
//                }
//                left++;
//            }
//
//            result = Math.max(result, right - left + 1);
//        }
//        return result;
//    }


    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int right = 0, result = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && (map.size() < k || (map.size() == k && map.containsKey(s.charAt(right))))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }

            result = Math.max(result, right - left);
            if (right < s.length()) {
                while (map.size() == k) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if (map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                        break;
                    }
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        LongestSubstringwithAtMostKDistinctCharacters test = new LongestSubstringwithAtMostKDistinctCharacters();
//        String a = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";  // 9 -> 36 j -> g
        String a = "aba";  // 9 -> 36 j -> g
//        String a = "abaccc";  // 9 -> 36 j -> g
//        System.out.print(a.length());
        int k = 1;
        System.out.print(test.lengthOfLongestSubstringKDistinct(a, k));
    }
}
