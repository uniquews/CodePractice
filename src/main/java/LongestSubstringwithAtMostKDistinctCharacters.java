import java.util.*;

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


//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if (s == null || s.length() == 0 || k == 0)
//            return 0;
//
//        Map<Character, Integer> map = new HashMap<>();
//        int right = 0, result = 0;
//        for (int left = 0; left < s.length(); left++) {
//            while (right < s.length() && (map.size() < k || (map.size() == k && map.containsKey(s.charAt(right))))) {
//                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
//                right++;
//            }
//
//            result = Math.max(result, right - left);
//            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
//            if (map.get(s.charAt(left)) == 0) {
//                map.remove(s.charAt(left));
//            }
//        }
//        return result;
//    }

    // O(klogK) follow up if it is data stream
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if (s == null || s.length() == 0 || k == 0)
//            return 0;
//
//        Map<Character, Integer> rightMost = new HashMap<>();
//        TreeMap<Integer, Character> window = new TreeMap<>();
//
//        int maxLen = 0;
//        int left = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char in = s.charAt(i);
//            if (rightMost.containsKey(in)) {
//                window.remove(rightMost.get(in));
//            }
//
//            rightMost.put(in, i);
//            window.put(i, in);
//
//            if (rightMost.size() > k) {
//                int first = window.keySet().iterator().next();
//                char tmp = window.get(first);
//                rightMost.remove(tmp);
//                window.remove(first);
//                left = first + 1;
//            }
//            maxLen = Math.max(maxLen, i - left + 1);
//        }
//        return maxLen;
//    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            if (map.containsKey(in)) {
                map.remove(in);
            }
            map.put(in, i);
            if (map.size() > k) {
                char out = map.keySet().iterator().next();
                left = map.get(out) + 1;
                map.remove(out);
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
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
