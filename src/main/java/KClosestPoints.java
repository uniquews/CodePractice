import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import utils.Point;

import java.util.*;

/**
 * Created by shuaiwang on 2/14/17.
 */
public class KClosestPoints {
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        Queue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return getDistance(b, origin) - getDistance(a, origin);
            }
        });

        for (int i = 0; i < points.length; i++) {
            q.add(points[i]);
            if (q.size() > k) {
                q.poll();
            }
        }

        Point[] result = new Point[k];
        int index = 0;
        Iterator<Point> iter = q.iterator();
        while (iter.hasNext()) {
            result[index] = iter.next();
            index++;
        }
        Arrays.sort(result, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int tmp1 = getDistance(o1, origin);
                int tmp2 = getDistance(o2, origin);
                if (tmp1 != tmp2) {
                    return tmp1 - tmp2;
                } else {
                    if (o1.x != o2.x) {
                        return o1.x - o2.x;
                    } else {
                        return o1.y - o2.y;
                    }
                }
            }
        });
        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }


    // quick select
//    public Point[] kClosest(Point[] points, Point origin, int k) {
//        // write your code here
//        List<Point> list = new ArrayList<>();
//        helper(points, origin, k, 0, points.length - 1, list);
//        Point[] result = new Point[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//
//        Arrays.sort(result, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                int tmp1 = getDistance(o1, origin);
//                int tmp2 = getDistance(o2, origin);
//                if (tmp1 != tmp2) {
//                    return tmp1 - tmp2;
//                } else {
//                    if (o1.x != o2.x) {
//                        return o1.x - o2.x;
//                    } else {
//                        return o1.y - o2.y;
//                    }
//                }
//            }
//        });
//        return result;
//    }
//
//    private void helper(Point[] points, Point origin, int k, int start, int end, List<Point> list) {
//        int pos = partition(points, origin, start, end);
//        if (pos + 1 == k) {
//            addAllPoints(list, points, origin, pos, k);
//        } else if (pos + 1 < k) {
//            helper(points, origin, k, pos + 1, end, list);
//        } else {
//            helper(points, origin, k, start, pos - 1, list);
//        }
//    }
//
//    private int partition(Point[] points, Point origin, int start, int end) {
//        int leftTail = start;
//        int pivot = getDistance(points[end], origin);
//        for (int i = start; i < end; i++) {
//            if (getDistance(points[i], origin) <= pivot) {
//                swap(points, i, leftTail);
//                leftTail++;
//            }
//        }
//        swap(points, leftTail, end);
//        return leftTail;
//    }
//
//    private void swap(Point[] points, int i, int j) {
//        Point tmp = points[i];
//        points[i] = points[j];
//        points[j] = tmp;
//    }
//
//    private void addAllPoints(List<Point> list, Point[] points, Point origin, int index, int k) {
//        while (index >= 0 && k > 0) {
//            list.add(points[index]);
//            index--;
//            k--;
//        }
//    }
//
//    private int getDistance(Point p, Point origin) {
//        return (p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y);
//    }

    public static void main(String[] args) {
        Point a = new Point(4,6);
        Point b = new Point(4,7);
        Point c = new Point(4,4);
        Point d = new Point(2,5);
        Point e = new Point(1,1);

        Point origin = new Point(0,0);
        Point[] p = {a,b,c,d,e};
        int k = 3;
        KClosestPoints test = new KClosestPoints();
        test.kClosest(p, origin, k);
    }
}
