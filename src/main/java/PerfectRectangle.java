import java.util.HashSet;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {

        HashSet<int[]> hashSet = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            int[] leftBottom = {rectangles[i][0], rectangles[i][1]};
            int[] rightBottom = {rectangles[i][2], rectangles[i][1]};
            int[] leftTop = {rectangles[i][0], rectangles[i][3]};
            int[] rightTop = {rectangles[i][2], rectangles[i][3]};

            if (hashSet.contains(leftBottom))
                hashSet.remove(leftBottom);
            else
                hashSet.add(leftBottom);
            if (hashSet.contains(rightBottom))
                hashSet.remove(rightBottom);
            else
                hashSet.add(rightBottom);
            if (hashSet.contains(leftTop))
                hashSet.remove(leftTop);
            else
                hashSet.add(leftTop);
            if (hashSet.contains(rightTop))
                hashSet.remove(rightTop);
            else
                hashSet.add(rightTop);
        }

        return hashSet.size() == 4 ? true : false;
    }
}
