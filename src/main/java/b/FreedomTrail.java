package b;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bohan on 4/30/17.
 */
public class FreedomTrail {
    private Map<String, Integer> cache = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        return rotate(ring, 0, key);
    }

    private int rotate(String ring, int startIndex, String key) {
        if (key == null || key.length() == 0) {
            return 0;
        }
        String customKey = key + String.valueOf(startIndex);
        if (cache.containsKey(customKey)) {
            return cache.get(customKey);
        }
        int totalMinStep = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            char target = key.charAt(0);
            if (target != ring.charAt(i)) {
                continue;
            }
            int distance = Math.abs(startIndex - i);
            int minStep = Math.min(distance, ring.length() - distance);
            totalMinStep = Math.min(minStep + rotate(ring, i, key.substring(1)), totalMinStep);
        }
        cache.put(customKey, totalMinStep + 1);
        return totalMinStep + 1;
    }
}
