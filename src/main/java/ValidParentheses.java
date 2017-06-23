import java.util.Stack;

/**
 * Created by shuaiwang on 6/22/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            } else {
                if (stk.isEmpty()) {
                    return false;
                }

                if (s.charAt(i) == '}') {
                    if (stk.peek() == '{') {
                        stk.pop();
                    } else {
                        return false;
                    }
                }

                if (s.charAt(i) == ')') {
                    if (stk.peek() == '(') {
                        stk.pop();
                    } else {
                        return false;
                    }
                }

                if (s.charAt(i) == ']') {
                    if (stk.peek() == '[') {
                        stk.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}
