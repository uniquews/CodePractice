import utils.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class KClosestPoints {
    public Point[] kClosest(Point[] points, final Point origin, int k) {
        // Write your code here

        PriorityQueue<Point> heap = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return getDistance(b, origin) - getDistance(a, origin);
            }
        });
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                continue;
            }
            if (heap.size() < k) {
                heap.add(points[i]);
            } else {
                Point maxPoint = heap.peek();
                if (getDistance(maxPoint, origin) > getDistance(points[i], origin)) {
                    heap.poll();
                    heap.add(points[i]);
                }
            }
        }

        Point[] result = new ArrayList<>(heap).toArray(new Point[heap.size()]);
        Arrays.sort(result, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (getDistance(a, origin) == getDistance(b, origin)) {
                    if (a.x != b.x) {
                        return b.x - a.x;
                    } else {
                        return a.y - b.y;
                    }
                } else {
                    return getDistance(a, origin) - getDistance(b, origin);
                }

            }
        });
        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
