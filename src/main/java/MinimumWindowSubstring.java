import java.util.HashMap;

/**
 * Created by shuaiwang on 12/14/16.
 */
public class MinimumWindowSubstring {
    /**
     * @param source: A string
     * @param target: A string
     * @return A string denote the minimum window
     * Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        HashMap<Character, Integer> visited = new HashMap<>();
        HashMap<Character, Integer> targetSet = new HashMap<>();

        int left = 0, right = 0, minLen = source.length(), result = -1, targetCount = 0, visitedCount = 0;

        for (char c : target.toCharArray()) {
            if (targetSet.containsKey(c)) {
                targetSet.put(c, targetSet.get(c) + 1);
            } else {
                targetSet.put(c, 1);
            }
            targetCount++;
        }


        for (; left < source.length(); left++) {
            while (right < source.length()) {
                if (targetCount == visitedCount) {
                    break;
                }
                char current = source.charAt(right);
                if (targetSet.containsKey(current)) {
                    if (!visited.containsKey(current) || targetSet.get(current) > visited.get(current)) {
                        visitedCount++;
                    }
                    if (visited.containsKey(source.charAt(right))) {
                        visited.put(source.charAt(right), visited.get(source.charAt(right)) + 1);
                    } else {
                        visited.put(source.charAt(right), 1);
                    }
                }
                right++;
            }

            if (targetCount == visitedCount && minLen >= right - left) {
                minLen = right - left;
                result = left;
            }

            if (targetSet.containsKey(source.charAt(left))) {
                visited.put(source.charAt(left), visited.get(source.charAt(left)) - 1);
                if (visited.get(source.charAt(left)) < targetSet.get(source.charAt(left))) {
                    visitedCount--;
                }
            }

        }

        return result == -1 ? "" : source.substring(result, result + minLen);
    }

    public static void main(String[] args) {
        //"ADOBECODEBANC", "ABC"
//        String source = "ADOBECODEBANC";
        String source = "abc";
//        String target = "ABC";
        String target = "ac";
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.print(test.minWindow(source, target));
    }
}
