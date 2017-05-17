import java.util.Stack;

/**
 * Created by shuaiwang on 5/16/17.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            int start = i;
            while (start < path.length() && path.charAt(start) == '/') {
                start++;
            }

            int end = start;
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }

            if (start == path.length())
                break;

            String current = path.substring(start, end);
            if (current.equals("..")) {
                if (!stk.isEmpty()) {
                    stk.pop();
                }
            } else if (current.equals(".")) {
                // do nothing
            } else {
                stk.push(current);
            }
            i = end;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            String tmp = "/" + stk.pop();
            sb.insert(0, tmp);
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
