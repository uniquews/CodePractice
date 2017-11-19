import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 4/16/17.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num.length(); i++) {
            String start = num.substring(0, i);
            long cur = Long.valueOf(start);
            dfs(num, target, cur, cur, i, sb.append(start), result);
            sb.setLength(0);
            if (start.equals("0")) {
                break;
            }
        }
        return result;
    }

    private void dfs(String num, int target, long cur, long last, int index, StringBuilder sb, List<String> result) {
        if (cur == target && index == num.length()) {
            result.add(sb.toString());
            return;
        }

        int len = sb.length();
        for (int i = index + 1; i <= num.length(); i++) {
            String str = num.substring(index, i);
            long tmp = Long.valueOf(str);
            dfs(num, target, cur + tmp, tmp, i, sb.append("+").append(str), result);
            sb.setLength(len);

            dfs(num, target, cur - tmp, -tmp, i, sb.append("-").append(str), result);
            sb.setLength(len);

            dfs(num, target, (cur - last) + last * tmp, last * tmp, i, sb.append("*").append(str), result);
            sb.setLength(len);

            if (str.equals("0")) {
                break;
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
