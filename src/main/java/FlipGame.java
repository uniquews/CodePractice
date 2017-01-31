import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/25/17.
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
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

    public static void main(String[] args) {
        String a = "++++";
        FlipGame test = new FlipGame();
        test.generatePossibleNextMoves(a);
    }
}
