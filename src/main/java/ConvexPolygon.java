import java.util.List;

/**
 * Created by shuaiwang on 4/29/17.
 */
public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long cur = 0, pre = 0;

        // 以每一个点出发，和前后相邻的两个点构成的向量（例如B点和A点，C点分别构成的向量BA和BC）。
        // 每两个向量的叉乘表示的一个平面的法向量，都必须在同一个方向上，才是凸多边形
        for (int i = 0; i < points.size(); i++) {
            List<Integer> a = points.get(i);
            List<Integer> b = points.get((i + 1) % n);
            List<Integer> c = points.get((i + 2) % n);
            cur = getVectorPerpendicualrOfBAAndBC(a, b, c);
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                } else {
                    pre = cur;
                }
            }
        }
        return true;
    }

    private long getVectorPerpendicualrOfBAAndBC(List<Integer> a, List<Integer> b, List<Integer> c) {
        long BAx = a.get(0) - b.get(0); // x1  // 已知点A, B, BA 向量等于 ((Ax - Bx), (Ay - By))
        long BAy = a.get(1) - b.get(1); // y1  // (Ax - Bx) 就是BA向量x轴上的方向， (Ay - By)就是BA向量y轴上的方向
        // above is vector BA

        long BCx = c.get(0) - b.get(0); // x2
        long BCy = c.get(1) - b.get(1); // y2
        // above is vector BC

        // BA 叉乘 BC  BA向量 和 BC 向量的叉乘 结果是两个向量的乘积的法向量。法向量的方向遵循右手定则
        // 右手从A点出发握向C点，大拇指的方向是法向量的方向。
        /***
         *   若a向量=(x1,y1),b向量=(x2,y2)，则有：
         *   a叉乘b 等于 x1*y2 - x2*y1  这是公式
         */
        long BAMulBC = BAx * BCy - BCx * BAy;
        return BAMulBC;
    }
}
