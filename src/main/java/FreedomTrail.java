import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shuaiwang on 4/30/17.
 */
public class FreedomTrail {
//    public int findRotateSteps(String ring, String key) {
//        HashMap<String, Integer> memo = new HashMap<>();
//        return dfs(ring, key, 0, 0, memo);
//    }
//
//    private int dfs(String ring, String key, int k, int r, HashMap<String, Integer> memo) {
//        if (k == key.length()) {
//            return 0;
//        }
//        String cashKey = k + "+" + r;
//        if (memo.containsKey(cashKey)) {
//            return memo.get(cashKey);
//        }
//
//        char target = key.charAt(k);
//        int minStepToK = Integer.MAX_VALUE;
//        for (int i = 0; i < ring.length(); i++) {
//            if (ring.charAt(i) == target) {
//
//                int step = Math.min(Math.abs(r - i), ring.length() - Math.abs(r - i));
//                minStepToK = Math.min(minStepToK, step + dfs(ring, key, k + 1, i, memo));
//            }
//        }
//        memo.put(cashKey, minStepToK + 1);
//        return minStepToK + 1;
//    }


    /**
     * f[i][j] 表示的是以ring.charAt(i)开始的，能匹配的以key.charAt(j)为开头的substring，需要的step
     *
     */
    public int findRotateSteps(String ring, String key) {
        int[][] f = new int[ring.length()][key.length()];

        for (int i = key.length() - 1; i >= 0; i--) {
            for (int j = 0; j < ring.length(); j++) {
                f[j][i] = Integer.MAX_VALUE;
                for (int k = 0; k < ring.length(); k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int step = Math.min(Math.abs(k - j), ring.length() - Math.abs(k - j));
                        if (i == key.length() - 1) {
                            f[j][i] = Math.min(step, f[j][i]);
                        } else {
                            f[j][i] = Math.min(f[k][i + 1] + step, f[j][i]);
                        }
                    }
                }
                f[j][i] += 1;
            }
        }
        return f[0][0];
    }
}
