package b;

import java.util.List;

/**
 * Created by bohan on 4/29/17.
 */
public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long prevNormal = 0; // 法向量 = normal, is a vector of perpendicular of AB x BC.
        for (int i = 0; i < n; i++) {
            List<Integer> currentPoint = points.get(i);
            List<Integer> prevPoint = points.get((i - 1 + n) % n);
            List<Integer> nextPoint = points.get((i + 1 + n) % n);
            long currentNormal = getNormal(currentPoint, prevPoint, nextPoint);
            if (currentNormal * prevNormal < 0) {
                return false;
            }
            prevNormal = currentNormal == 0 ? prevNormal : currentNormal;
        }
        return true;
    }

    /**
     * 求向量积 http://baike.baidu.com/item/%E5%B9%B3%E9%9D%A2%E5%90%91%E9%87%8F#4_5
     */
    private long getNormal(List<Integer> current, List<Integer> prev, List<Integer> next) {
        // prev - current.
        int dx1 = prev.get(0) - current.get(0);
        int dy1 = prev.get(1) - current.get(1);
        // next - current.
        int dx2 = next.get(0) - current.get(0);
        int dy2 = next.get(1) - current.get(1);
        return dx1 * dy2 - dx2 * dy1;
    }
}
