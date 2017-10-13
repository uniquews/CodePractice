import java.util.Stack;

/**
 * Created by shuaiwang on 4/9/17.
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int sign = 1;
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                result += sign * Integer.valueOf(s.substring(i, j));
                i = j - 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stk.push(result);
                stk.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')'){ // 还可能是空
                int si = stk.pop();
                int prev = stk.pop();
                result = result * si + prev;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator test = new BasicCalculator();
        System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
