import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null) {
            return result;
        }

        Map<Character, Integer> occur = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            occur.put(p.charAt(i), occur.getOrDefault(p.charAt(i), 0) + 1);
            visited.put(p.charAt(i), 0);
        }
        int count = 0;

        int right = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && count < p.length()) {
                char c = s.charAt(right);
                if (occur.containsKey(c)) {
                    if (visited.get(c) < occur.get(c)) {
                        count++;
                    }
                    visited.put(c, visited.get(c) + 1);
                }
                right++;
            }

            if (count == p.length() && right - left == p.length()) {
                result.add(left);
            }

            char l = s.charAt(left);
            if (occur.containsKey(l)) {
                visited.put(l, visited.get(l) - 1);
                if (visited.get(l) < occur.get(l)) {
                    count--;
                }
            }
        }
        return result;
    }
}
