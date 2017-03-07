import java.util.HashSet;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int sumOfSmallRectangles = 0, leftMostX = Integer.MAX_VALUE, rightMostX = 1,
                bottomMostY = Integer.MAX_VALUE, upMostY = 1;
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            String leftBottom = rectangles[i][0] + "," + rectangles[i][1];
            String rightBottom = rectangles[i][2] + "," + rectangles[i][1];
            String leftTop = rectangles[i][0] + "," + rectangles[i][3];
            String rightTop = rectangles[i][2] + ","+ rectangles[i][3];

            if (!hashSet.add(leftBottom))
                hashSet.remove(leftBottom);

            if (!hashSet.add(rightBottom))
                hashSet.remove(rightBottom);

            if (!hashSet.add(leftTop))
                hashSet.remove(leftTop);

            if (!hashSet.add(rightTop))
                hashSet.remove(rightTop);

            sumOfSmallRectangles += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);

            leftMostX = Math.min(rectangles[i][0], leftMostX);
            rightMostX = Math.max(rectangles[i][2], rightMostX);
            bottomMostY = Math.min(rectangles[i][1], bottomMostY);
            upMostY = Math.max(rectangles[i][3], upMostY);
        }

        return hashSet.size() == 4 && (rightMostX - leftMostX) * (upMostY - bottomMostY) ==  sumOfSmallRectangles &&
                hashSet.contains(leftMostX + "," + bottomMostY) && hashSet.contains(leftMostX + "," + upMostY) &&
                hashSet.contains(rightMostX + "," + bottomMostY) && hashSet.contains(rightMostX + "," + upMostY);
    }

    //[[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]

    public static void main(String[] args) {
        int[][] rectangles = {{0,0,1,1},{0,0,2,1},{1,0,2,1},{0,2,2,3}};
        PerfectRectangle test = new PerfectRectangle();
        test.isRectangleCover(rectangles);
    }
}
