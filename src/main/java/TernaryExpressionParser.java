import java.util.Stack;

/**
 * Created by shuaiwang on 1/16/17.
 */
public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        Stack<String> stk = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            if (expression.charAt(i) == ':') {
                continue;
            } else if (expression.charAt(i) != '?') {
                stk.push(String.valueOf(expression.charAt(i)));
            } else if (expression.charAt(i) == '?') {
                if (expression.charAt(i - 1) == 'T') {
                    String value = stk.pop();
                    stk.pop();
                    stk.push(value);
                } else {
                    stk.pop();
                    String value = stk.pop();
                    stk.push(value);
                }
                i--;
            }
        }
        return stk.peek();
    }


}
