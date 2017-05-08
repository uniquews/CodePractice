import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuaiwang on 5/3/17.
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                long dis = getDistance(points[i], points[j]);
                if (!hashMap.containsKey(dis)) {
                    hashMap.put(dis, 1);
                } else {
                    hashMap.put(dis, hashMap.get(dis) + 1);
                }
            }

            for(int val : hashMap.values()) {
                result += val * (val-1);
            }
        }
        return result;
    }

    private long getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
