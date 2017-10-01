import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 12/14/16.
 */
public class MinimumWindowSubstring {
//    /**
//     * @param source: A string
//     * @param target: A string
//     * @return A string denote the minimum window
//     * Return "" if there is no such a string
//     */
//    public String minWindow(String source, String target) {
//        // write your code
//        HashMap<Character, Integer> visited = new HashMap<>();
//        HashMap<Character, Integer> targetSet = new HashMap<>();
//
//        int left = 0, right = 0, minLen = source.length(), result = -1, targetCount = 0, visitedCount = 0;
//
//        for (char c : target.toCharArray()) {
//            if (targetSet.containsKey(c)) {
//                targetSet.put(c, targetSet.get(c) + 1);
//            } else {
//                targetSet.put(c, 1);
//            }
//            targetCount++;
//        }
//
//
//        for (; left < source.length(); left++) {
//            while (right < source.length()) {
//                if (targetCount == visitedCount) {
//                    break;
//                }
//                char current = source.charAt(right);
//                if (targetSet.containsKey(current)) {
//                    if (!visited.containsKey(current) || targetSet.get(current) > visited.get(current)) {
//                        visitedCount++;
//                    }
//                    if (visited.containsKey(source.charAt(right))) {
//                        visited.put(source.charAt(right), visited.get(source.charAt(right)) + 1);
//                    } else {
//                        visited.put(source.charAt(right), 1);
//                    }
//                }
//                right++;
//            }
//
//            if (targetCount == visitedCount && minLen >= right - left) {
//                minLen = right - left;
//                result = left;
//            }
//
//            if (targetSet.containsKey(source.charAt(left))) {
//                visited.put(source.charAt(left), visited.get(source.charAt(left)) - 1);
//                if (visited.get(source.charAt(left)) < targetSet.get(source.charAt(left))) {
//                    visitedCount--;
//                }
//            }
//
//        }
//
//        return result == -1 ? "" : source.substring(result, result + minLen);
//    }


//    public String minWindow(String s, String t) {
//        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
//            return "";
//        }
//
//        Map<Character, Integer> needed = new HashMap<>();
//        Map<Character, Integer> visited = new HashMap<>();
//
//        for (int i = 0; i < t.length(); i++) {
//            needed.put(t.charAt(i), needed.getOrDefault(t.charAt(i), 0) + 1);
//            visited.put(t.charAt(i), 0);
//        }
//
//        int result = Integer.MAX_VALUE, count = 0, right = 0, startIndex = -1;
//
//        for (int left = 0; left < s.length(); left++) {
//            while (right < s.length() && count < t.length()) {
//                char current = s.charAt(right);
//                if (needed.containsKey(current)) {
//                    if (visited.get(current) < needed.get(current)) {
//                        count++;
//                    }
//                    visited.put(current, visited.getOrDefault(current, 0) + 1);
//                }
//                right++;
//            }
//
//            if (count == t.length() && right - left < result) {
//                startIndex = left;
//                result = right - left;
//            }
//
//            char current = s.charAt(left);
//            if (needed.containsKey(current)) {
//                visited.put(current, visited.get(current) - 1);
//                if (visited.get(current) < needed.get(current)) {
//                    count--;
//                }
//            }
//        }
//        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + result);
//    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> occur = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();
        int size = t.length();
        int count = 0;
        int minWin = s.length();
        int start = -1;

        for (int i = 0; i < t.length(); i++) {
            occur.put(t.charAt(i), occur.getOrDefault(t.charAt(i), 0) + 1);
            visited.put(t.charAt(i), 0);
        }

        int right = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count < size) {
                char c = s.charAt(right);
                if (occur.containsKey(c)) {
                    if (visited.get(c) < occur.get(c)) {
                        count++;
                    }
                    visited.put(c, visited.get(c) + 1);
                }
                right++;
            }

            if (count == size) {
                if (minWin >= right - left) { // minWin如果被初始化为s.length, 这个地方就要用 >=
                    minWin = right - left;
                    start = left;
                }
            }

            char l = s.charAt(left);
            if (occur.containsKey(l)) {
                visited.put(l, visited.get(l) - 1);
                if (visited.get(l) < occur.get(l)) {
                    count--;
                }
            }
        }
        if (start == -1)
            return "";
        return s.substring(start, start + minWin);
    }

    public static void main(String[] args) {
        //"ADOBECODEBANC", "ABC"
//        String source = "ADOBECODEBANC";
        /**
         * "cabwefgewcwaefgcf"
         "cae"
         * */
        String source = "a";
//        String target = "ABC";
        String target = "a";
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.print(test.minWindow(source, target));
    }
}
