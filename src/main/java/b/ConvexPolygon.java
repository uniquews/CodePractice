package b;

/**
 * Created by bohan on 4/29/17.
 */
public class ConvexPolygon {
    public boolean isConvex(int[][] points) {
        int n = points.length;
        long prevNormal = 0; // 法向量 = normal, is a vector of perpendicular of AB x BC.
        for (int i = 0; i < n; i++) {
            int[] currentPoint = points[i];
            int[] prevPoint = points[(i - 1 + n) % n];
            int[] nextPoint = points[(i + 1 + n) % n];
            long currentNormal = getNormal(currentPoint, prevPoint, nextPoint);
            if (!(currentNormal == 0 || currentNormal * prevNormal >= 0)) {
                return false;
            }
            prevNormal = currentNormal == 0 ? prevNormal : currentNormal;
        }
        return true;
    }

    /**
     * 求向量积 http://baike.baidu.com/item/%E5%B9%B3%E9%9D%A2%E5%90%91%E9%87%8F#4_5
     */
    private long getNormal(int[] current, int[] prev, int[] next) {
        // prev - current.
        int dx1 = prev[0] - current[0];
        int dy1 = prev[1] - current[1];
        // next - current.
        int dx2 = next[0] - current[0];
        int dy2 = next[1] - current[1];
        return dx1 * dy2 - dx2 * dy1;
    }
}
