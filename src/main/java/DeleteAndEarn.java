import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {
    // House Robber 的变形题  dp用O(1)空间的那种做法
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + n);
        }

        int prev = 0;
        int cur = 0;
        for (int n : map.keySet()) {
            if (!map.containsKey(n - 1)) {
                prev = cur;
                cur += map.get(n);
            } else {
               int tmp = Math.max(prev + map.get(n), cur);
               prev = cur;
               cur = tmp;
            }
        }
        return cur;
    }
}
