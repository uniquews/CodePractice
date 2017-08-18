import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class MeetingRoomsII {
    class Node {
        int t;
        boolean isLeft;
        Node(int t, boolean isLeft) {
            this.t = t;
            this.isLeft = isLeft;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Node> l = new ArrayList<>();
        for (Interval i : intervals) {
            Node left = new Node(i.start, true);
            Node right = new Node(i.end, false);
            l.add(left);
            l.add(right);
        }

        Collections.sort(l, (o1, o2) -> {
            if (o1.t < o2.t) {
                return -1;
            } else if (o1.t > o2.t) {
                return 1;
            } else {
                if (o1.isLeft && !o2.isLeft) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int result = 0;
        int count = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).isLeft) {
                count++;
            } else {
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
