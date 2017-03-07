import java.util.HashSet;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            String leftBottom = rectangles[i][0] + "," + rectangles[i][1];
            String rightBottom = rectangles[i][2] + "," + rectangles[i][1];
            String leftTop = rectangles[i][0] + ", " + rectangles[i][3];
            String rightTop = rectangles[i][2] + ", "+ rectangles[i][3];

            if (!hashSet.add(leftBottom))
                hashSet.remove(leftBottom);

            if (!hashSet.add(rightBottom))
                hashSet.remove(rightBottom);

            if (!hashSet.add(leftTop))
                hashSet.remove(leftTop);

            if (!hashSet.add(rightTop))
                hashSet.remove(rightTop);

        }

        return hashSet.size() == 4;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        PerfectRectangle test = new PerfectRectangle();
        test.isRectangleCover(rectangles);
    }
}
