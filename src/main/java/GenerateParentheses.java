import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/20/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, sb, n, 0, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int n, int left, int right) {
        if (left > n) {
            return;
        }

        if (right == left && right == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            helper(result, sb, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            helper(result, sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
