import java.util.*;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;
            while (size > 0) {
                String current = q.poll();
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }
                for (int i = 0; i < current.length(); i++) {
                    String next = current.substring(0, i) + current.substring(i + 1);
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }
                size--;
            }
            if (found) {
                break;
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                continue;
            }
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String a = ")d))";
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        test.removeInvalidParentheses(a);
    }
}
