import java.util.Stack;

/**
 * Created by shuaiwang on 4/9/17.
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> stk = new Stack<>();
        int index = 0;
        stk.push("+");
        while (index <= s.length()) {
            if (index < s.length() && s.charAt(index) == ' ') {
                index++;
                continue;
            }
            if (index == s.length() || s.charAt(index) == ')') {
                int result = 0;
                while (!stk.isEmpty() && !stk.peek().equals("(")) {
                    int number = Integer.valueOf(stk.pop());
                    String operator = stk.pop();
                    if (operator.equals("+")) {
                        result += number;
                    } else {
                        result -= number;
                    }
                }
                if (index < s.length() && s.charAt(index) == ')') {
                    stk.pop(); // pop (
                }
                stk.push(String.valueOf(result));
                index++;
            } else {
                if (s.charAt(index) == '+' || s.charAt(index) == '-' || s.charAt(index) == '(') {
                    if (s.charAt(index) == '(') {
                        stk.push(s.substring(index, index + 1));
                        stk.push("+");
                    } else {
                        stk.push(s.substring(index, index + 1));
                    }
                    index++;
                } else {
                    int start = index;
                    int end = index;
                    while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
                        char tmp =s.charAt(end);
                        end++;
                    }
                    stk.push(s.substring(start, end));
                    index = end;
                }
            }
        }
        return Integer.valueOf(stk.peek());
    }

    public static void main(String[] args) {
        BasicCalculator test = new BasicCalculator();
        System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
