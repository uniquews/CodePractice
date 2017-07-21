import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 1/25/17.
 */
public class FlipGameII {
    private HashMap<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if (s == null || s.length() == 0)
            return false;
        if (map.containsKey(s)) return map.get(s);

        for (int i = 0; i < s.length() - 1; i++) {
            String current = s.substring(i, i + 2);
            if (current.equals("++")) {
                String next = s.substring(0, i);
                next += "--";
                if (i + 2 <= s.length()) {
                    next += s.substring(i + 2);
                }

                if (!canWin(next)) {
                    map.put(current, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String a = "++";
        FlipGameII test = new FlipGameII();
        System.out.print(test.canWin(a));
    }
}
