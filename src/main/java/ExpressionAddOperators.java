import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/16/17.
 */
public class ExpressionAddOperators {
//    public List<String> addOperators(String num, int target) {
//        List<String> result = new ArrayList<>();
//        dfs(num, result, "", target, 0, 0, 0);
//        return result;
//    }
//
//    private void dfs(String num, List<String> result, String eachResult, int target, int pos, long value, long latestValueAfterPlusOrMonus) {
//        if (pos == num.length()) {
//            if (value == target)
//                result.add(eachResult);
//            return;
//        }
//
//        for (int i = pos; i < num.length(); i++) {
//            // 105 不能出现1 * 5， 碰到05 不能返回5
//            if (num.charAt(pos) == '0' && i != pos) {
//                break;
//            }
//            long current = Long.parseLong(num.substring(pos, i + 1));
//            if (pos == 0) {
//                dfs(num, result, eachResult + String.valueOf(current), target,i + 1, current, current);
//            } else {
//                dfs(num, result, eachResult + "+" + current, target, i + 1, value + current, current);
//                dfs(num, result, eachResult + "-" + current, target, i + 1, value - current, -current);
//                dfs(num, result, eachResult + "*" + current, target,i + 1, value - latestValueAfterPlusOrMonus + latestValueAfterPlusOrMonus * current, latestValueAfterPlusOrMonus * current);
//            }
//        }
//    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, 0, target, result, "", 0, 0);
        return result;
    }

    private void dfs(String num, int index, int target, List<String> result, String eachResult, long value, long valueAfterLastPlusOrMinus) {
        if (index == num.length() && value == target) {
            result.add(eachResult);
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i != index) {
                break;
            }
            String current = num.substring(index, i + 1);
            long v = Long.valueOf(current);

            if (index == 0) {
                dfs(num, i + 1, target, result, eachResult + current, value + v, v);
            } else {
                dfs(num, i + 1, target, result, eachResult + "+" + current, value + v, v);
                dfs(num, i + 1, target, result, eachResult + "-" + current, value - v, -v);
                dfs(num, i + 1, target, result, eachResult + "*" + current, value - valueAfterLastPlusOrMinus + valueAfterLastPlusOrMinus * v, valueAfterLastPlusOrMinus * v);
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
