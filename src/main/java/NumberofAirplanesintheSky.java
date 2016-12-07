import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 12/3/16.
 */
public class NumberofAirplanesintheSky {
    class Point{
        private int time;
        private int fly;

        public Point(int t, int f) {
            time = t;
            fly = f;
        }
    }

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Point> points = new ArrayList<>(airplanes.size() * 2);
        for (Interval plane : airplanes) {
            Point a = new Point(plane.start, 1);
            Point b = new Point(plane.end, 0);
            points.add(a);
            points.add(b);
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.time == o2.time) {
                    return o1.fly - o2.fly;
                }

                return o1.time - o2.time;
            }
        });

        int count = 0;
        int result = 0;
        for (Point p : points) {
            if (p.fly == 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count--;
            }
        }
        return result;
    }

}
