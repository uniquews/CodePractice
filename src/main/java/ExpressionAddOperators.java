import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/16/17.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, result, "", target, 0, 0, 0);
        return result;
    }

    private void dfs(String num, List<String> result, String eachResult, int target, int pos, long value, long latestValueAfterPlusOrMonus) {
        if (pos == num.length()) {
            if (value == target)
                result.add(eachResult);
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // 105 不能出现1 * 5， 碰到05 不能返回5
            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }
            long current = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(num, result, eachResult + String.valueOf(current), target,i + 1, current, current);
            } else {
                dfs(num, result, eachResult + "+" + current, target, i + 1, value + current, current);
                dfs(num, result, eachResult + "-" + current, target, i + 1, value - current, -current);
                dfs(num, result, eachResult + "*" + current, target,i + 1, value - latestValueAfterPlusOrMonus + latestValueAfterPlusOrMonus * current, latestValueAfterPlusOrMonus * current);
            }
        }
    }
}
