package b;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (isValid(tmp)) {
                res.add(tmp);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) != '(' && tmp.charAt(i) != ')') {
                    continue;
                }
                String newStr = new StringBuilder(tmp).deleteCharAt(i).toString();
                if (!visited.contains(newStr)) {
                    q.offer(newStr);
                    visited.add(newStr);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
            if (counter < 0) {
                return false;
            }
        }
        return counter == 0;
    }
}
