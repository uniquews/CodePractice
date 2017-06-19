import java.util.Stack;

/**
 * Created by shuaiwang on 5/16/17.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] p = path.split("/");

        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("") || p[i].equals(".")) {
                continue;
            } else if (p[i].equals("..")) {
                if (stk.size() != 0) { // test case: /../
                    stk.pop();
                }
            } else {
                stk.push(p[i]);
            }
        }

        if (stk.size() == 0) {
            return "/";
        }

        while (!stk.isEmpty()) {
            StringBuilder tmp = new StringBuilder();
            tmp.append("/").append(stk.pop());
            sb.insert(0, tmp.toString());
        }
        return sb.toString();
    }
}
