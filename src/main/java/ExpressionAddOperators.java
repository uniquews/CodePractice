import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/16/17.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, 0, target, result, 0, 0, "");
        return result;
    }

    private void dfs(String num, int index, int target, List<String> result, long current, long last, String eachResult) {
        if (index == num.length()) {
            if (current == target) {
                result.add(eachResult);
            }
            return;
        }

        if (index == 0) {
            if (num.charAt(index) == '0') {
                dfs(num, index + 1, target, result, current, last, "0");
            } else {
                for (int i = index + 1; i <= num.length(); i++) {
                    long n = Long.valueOf(num.substring(index, i));
                    dfs(num, i, target, result, n, n, num.substring(index, i));
                }
            }
        } else {
            if (num.charAt(index) == '0') {
                dfs(num, index + 1, target, result, current, 0, eachResult + "+0");
                dfs(num, index + 1, target, result, current, 0, eachResult + "-0");
                dfs(num, index + 1, target, result, current - last, 0, eachResult + "*0"); // *
            } else {
                for (int i = index + 1; i <= num.length(); i++) {
                    long n = Long.valueOf(num.substring(index, i));
                    dfs(num, i, target, result, current + n, n, eachResult + "+" + n);
                    dfs(num, i, target, result, current - n, -n, eachResult + "-" + n);
                    dfs(num, i, target, result, current - last + last * n, last * n, eachResult + "*" + n);
                }
            }
        }
    }

    public static void main(String[] args) {
        String a = "105";
        int target = 5;
        ExpressionAddOperators test = new ExpressionAddOperators();
        test.addOperators(a, target);
    }
}
