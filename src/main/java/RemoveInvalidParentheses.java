import java.util.*;

/**
 * Created by shuaiwang on 5/13/17.
 */
public class RemoveInvalidParentheses {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList<>();
//        Set<String> visited = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//
//        q.add(s);
//        visited.add(s);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            boolean found = false;
//            while (size > 0) {
//                String current = q.poll();
//                int count = helper(current);
//                if (count == 0) {
//                    result.add(current);
//                    found = true;
//                }
//                for (int i = 0; i < current.length(); i++) {
//                    String next = current.substring(0, i) + current.substring(i + 1);
//                    if (!visited.contains(next) && helper(current.substring(0, i)) >= 0 ) {
//                        q.add(next);
//                        visited.add(next);
//                    }
//                }
//                size--;
//            }
//            if (found) {
//                break;
//            }
//        }
//        return result;
//    }
//
//    private int helper(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLetter(s.charAt(i))) {
//                continue;
//            }
//            if (s.charAt(i) == '(') {
//                count++;
//            } else {
//                count--;
//            }
//            if (count < 0) {
//                return -1;
//            }
//        }
//        return count;
//    }

    public List<String> removeInvalidParentheses(String s) {
        int[] removed = preprocess(s);
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        helper(s, set, 0, sb, removed[0], removed[1], 0);
        List<String> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    private void helper(String s, Set<String> result, int index, StringBuilder sb, int left, int right, int open) {
        if (left < 0 || right < 0 || open < 0) {
            return;
        }

        if (index == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                result.add(sb.toString());
            }
            return;
        }
        int len = sb.length();
        if (s.charAt(index) == '(') {
            helper(s, result, index + 1, sb, left - 1, right, open);
            sb.append('(');
            helper(s, result, index + 1, sb, left, right, open + 1);
        } else if (s.charAt(index) == ')') {
            helper(s, result, index + 1, sb, left, right - 1, open);
            sb.append(')');
            helper(s, result, index + 1 , sb, left, right, open - 1);
        } else {
            sb.append(s.charAt(index));
            helper(s, result, index + 1, sb, left, right, open);
        }
        sb.setLength(len);
    }

    private int[] preprocess(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i) == '(') {
                left++;
            } else {
                left--;
            }

            if (left < 0) {
                right++;
                left = 0;
            }
        }
        int[] result = new int[2];
        result[0] = left;
        result[1] = right;
        return result;
    }

    public static void main(String[] args) {
//        String a = "()())()"; // j == last_j || s.charAt(j - 1) != par[1]
//        String a = "((k()"; // for (int j = last_j; j <= i; ++j)
        String a = "())()";
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        test.removeInvalidParentheses(a);
    }
}
