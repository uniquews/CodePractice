import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by shuaiwang on 4/15/17.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        int leftX = Integer.MAX_VALUE, rightX = Integer.MIN_VALUE;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            leftX = Math.min(points[i][0], leftX);
            rightX = Math.max(points[i][0], rightX);
            set.add(new ArrayList<>(Arrays.asList(points[i][0], points[i][1])));
        }

        double mid = leftX + (rightX - leftX) / 2.0;

        for (int i = 0; i < points.length; i++) {
            int target = (int)(2 * mid) - points[i][0]; // 这个很巧妙
            if (!set.contains(new ArrayList<>(Arrays.asList(target, points[i][1])))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LineReflection test = new LineReflection();
        int[][] points = {{0,1}, {1, 1}};
        test.isReflected(points);
    }
}
