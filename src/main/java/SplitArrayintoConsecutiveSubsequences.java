import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 8/14/17.
 */
public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> nextPossibleNum = new HashMap<>();

        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (freq.get(i) == 0)
                continue;
            freq.put(i, freq.get(i) - 1);
            if (nextPossibleNum.get(i) > 0) {
                nextPossibleNum.put(i, nextPossibleNum.get(i) - 1);
                nextPossibleNum.put(i + 1, nextPossibleNum.getOrDefault(i + 1, 0) + 1);
            } else if (freq.get(i + 1) > 0 && freq.get(i + 2) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                nextPossibleNum.put(i + 3, nextPossibleNum.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
