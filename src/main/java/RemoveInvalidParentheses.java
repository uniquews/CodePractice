import java.util.*;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        if (s == null) {
            return result;
        }

        boolean foundInLongestLevel = false;

        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                result.add(cur);
                foundInLongestLevel = true;
                continue;
            }

            if (foundInLongestLevel) continue;

            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String next = cur.substring(0, i) + cur.substring(i + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')'){
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String a = ")d))";
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        test.removeInvalidParentheses(a);
    }
}
