import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 8/30/17.
 */
public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, 0, input.length() - 1);
    }

    private List<Integer> helper(String s, int start, int end) {
        List<Integer> result = new ArrayList<>();

        if (!hasOperator(s, start, end)) {
            result.add(Integer.valueOf(s.substring(start, end + 1)));
            return result;
        }

        for (int i = start; i <= end; i++) {
            if (Character.isDigit(s.charAt(i))) {
                continue;
            }
            List<Integer> left = helper(s, start, i - 1);
            List<Integer> right = helper(s, i + 1, end);
            for (int m = 0; m < left.size(); m++) {
                for (int n = 0; n < right.size(); n++) {
                    if (s.charAt(i) == '+') {
                        result.add(left.get(m) + right.get(n));
                    } else if (s.charAt(i) == '-') {
                        result.add(left.get(m) - right.get(n));
                    } else if (s.charAt(i) == '*') {
                        result.add(left.get(m) * right.get(n));
                    }
                }
            }
        }
        return result;
    }

    private boolean hasOperator(String s, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
