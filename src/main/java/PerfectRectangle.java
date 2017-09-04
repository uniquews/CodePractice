import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaiwang on 3/6/17.
 */
public class PerfectRectangle {
//    public boolean isRectangleCover(int[][] rectangles) {
//        int sumOfSmallRectangles = 0, leftMostX = Integer.MAX_VALUE, rightMostX = 1,
//                bottomMostY = Integer.MAX_VALUE, upMostY = 1;
//        HashSet<String> hashSet = new HashSet<>();
//        for (int i = 0; i < rectangles.length; i++) {
//            String leftBottom = rectangles[i][0] + "," + rectangles[i][1];
//            String rightBottom = rectangles[i][2] + "," + rectangles[i][1];
//            String leftTop = rectangles[i][0] + "," + rectangles[i][3];
//            String rightTop = rectangles[i][2] + ","+ rectangles[i][3];
//
//            if (!hashSet.add(leftBottom))
//                hashSet.remove(leftBottom);
//
//            if (!hashSet.add(rightBottom))
//                hashSet.remove(rightBottom);
//
//            if (!hashSet.add(leftTop))
//                hashSet.remove(leftTop);
//
//            if (!hashSet.add(rightTop))
//                hashSet.remove(rightTop);
//
//            sumOfSmallRectangles += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
//
//            leftMostX = Math.min(rectangles[i][0], leftMostX);
//            rightMostX = Math.max(rectangles[i][2], rightMostX);
//            bottomMostY = Math.min(rectangles[i][1], bottomMostY);
//            upMostY = Math.max(rectangles[i][3], upMostY);
//        }
//
//        return hashSet.size() == 4 && (rightMostX - leftMostX) * (upMostY - bottomMostY) ==  sumOfSmallRectangles &&
//                hashSet.contains(leftMostX + "," + bottomMostY) && hashSet.contains(leftMostX + "," + upMostY) &&
//                hashSet.contains(rightMostX + "," + bottomMostY) && hashSet.contains(rightMostX + "," + upMostY);
//    }

    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> points = new HashSet<>();
        int area = 0, leftMost = Integer.MAX_VALUE, rightMost = Integer.MIN_VALUE, topMost = Integer.MIN_VALUE,
                bottomMost = Integer.MAX_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            int[] r = rectangles[i];
            String leftBottom = r[0] + "," + r[1];
            String leftTop = r[0] + "," + r[3];
            String rightBottom = r[2] + "," + r[1];
            String rightTop = r[2] + "," + r[3];

            if (points.contains(leftBottom)) {
                points.remove(leftBottom);
            } else {
                points.add(leftBottom);
            }

            if (points.contains(leftTop)) {
                points.remove(leftTop);
            } else {
                points.add(leftTop);
            }

            if (points.contains(rightBottom)) {
                points.remove(rightBottom);
            } else {
                points.add(rightBottom);
            }

            if (points.contains(rightTop)) {
                points.remove(rightTop);
            } else {
                points.add(rightTop);
            }
            leftMost = Math.min(leftMost, r[0]);
            rightMost = Math.max(rightMost, r[2]);
            topMost = Math.max(topMost, r[3]);
            bottomMost = Math.min(bottomMost, r[1]);

            area += (r[2] - r[0]) * (r[3] - r[1]);
        }

        return points.size() == 4 && ((rightMost - leftMost) * (topMost - bottomMost) == area) &&
                points.contains(leftMost + "," + bottomMost) && points.contains(leftMost + "," + topMost) &&
                points.contains(rightMost + "," + bottomMost) && points.contains(rightMost + "," + topMost);
    }


    //[[0,0,1,1],[0,0,2,1],[1,0,2,1],[0,2,2,3]]
    // [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        PerfectRectangle test = new PerfectRectangle();
        test.isRectangleCover(rectangles);
    }
}
