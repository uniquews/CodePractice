import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/20/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, "", result);
        return result;
    }

    private void dfs(int n, int left, int right, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            dfs(n, left + 1, right, s + "(", result);
        }

        if (right < left) {
            dfs(n, left, right + 1, s + ")", result);
        }
    }
}
