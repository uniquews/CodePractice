package fb;


import java.util.HashMap;
import java.util.Map;

/**
 * follow up: String t中的character没有个数要求，eg. AAAAABBX和ABX的结果应该是相同的。
 *
 * 应该就是把 occur中出现次数改为1
 * 不在是判断count和target length的关系， 而是count 和target中Unique char 的个数的关系
 *
 * */
public class MinimumWindowFollowup {

    public String minWindow(String s, String t) {
        Map<Character, Integer> occur = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();

        int count = 0;
        int right = 0;
        int minLen = s.length();
        int start = -1;

        for (int i = 0; i < t.length(); i++) {
            occur.put(t.charAt(i), 1);
            visited.put(t.charAt(i), 0);
        }

        int size = occur.keySet().size();

        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count < size) {
                if (occur.containsKey(s.charAt(right))) {
                    if (occur.get(s.charAt(right)) > visited.get(s.charAt(right))) {
                        count++;
                    }
                    visited.put(s.charAt(right), visited.get(s.charAt(right)) + 1);
                }
                right++;
            }


            if (count == size && minLen >= right - left) {
                start = left;
                minLen = right - left;
            }

            if (occur.containsKey(s.charAt(left))) {
                visited.put(s.charAt(left), visited.get(s.charAt(left)) - 1);
                if (visited.get(s.charAt(left)) < occur.get(s.charAt(left))) {
                    count--;
                }
            }
        }

        if (start == -1) {
            return "";
        }

        return s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "AAAAABC";
        MinimumWindowFollowup test = new MinimumWindowFollowup();
        System.out.print(test.minWindow(a, b));
    }
}
