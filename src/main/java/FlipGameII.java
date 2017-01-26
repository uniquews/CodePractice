import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/25/17.
 */
public class FlipGameII {
    public boolean canWin(String s) {
        List<String> level = generatePossibleNextMoves(s);
        if (isFinalResultInList(level))
            return true;

        for (int i = 0; i < level.size(); i++) {
            if (!canWin(level.get(i))) {
                return true;
            }
        }
        return false;
    }


    private List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp;
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                tmp = s.substring(0, i) + "--";
                if (i < s.length() - 2) {
                    tmp += s.substring(i + 2, s.length());
                }
                result.add(tmp);
            }

        }
        return result;
    }

    private boolean isFinalResultInList(List<String> level) {
        for (String s : level) {
            if (isNoConsecutiveTwoPlus(s))
                return true;
        }
        return false;
    }

    private boolean isNoConsecutiveTwoPlus(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("++")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "++";
        FlipGameII test = new FlipGameII();
        System.out.print(test.canWin(a));
    }
}
