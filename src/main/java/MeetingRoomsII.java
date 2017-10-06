import utils.Interval;

import java.util.*;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class MeetingRoomsII {
//    class Node {
//        int t;
//        boolean isLeft;
//        Node(int t, boolean isLeft) {
//            this.t = t;
//            this.isLeft = isLeft;
//        }
//    }
//
//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return 0;
//        }
//        List<Node> l = new ArrayList<>();
//        for (Interval i : intervals) {
//            Node left = new Node(i.start, true);
//            Node right = new Node(i.end, false);
//            l.add(left);
//            l.add(right);
//        }
//
//        Collections.sort(l, (o1, o2) -> {
//            if (o1.t < o2.t) {
//                return -1;
//            } else if (o1.t > o2.t) {
//                return 1;
//            } else {
//                if (o1.isLeft && !o2.isLeft) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });
//
//        int result = 0;
//        int count = 0;
//        for (int i = 0; i < l.size(); i++) {
//            if (l.get(i).isLeft) {
//                count++;
//            } else {
//                count--;
//            }
//            result = Math.max(result, count);
//        }
//        return result;
//    }

    class Node {
        public int index;
        public boolean isLeft;
        public Node(int i, boolean l) {
            index = i;
            isLeft = l;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            Node left = new Node(intervals[i].start, true);
            Node right = new Node(intervals[i].end, false);
        }

        Collections.sort(list, (a, b) -> {
            if (a.index != b.index) {
                return a.index - b.index;
            } else {
                if (a.isLeft && !b.isLeft) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int count = 0;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLeft) {
                count++;
            } else {
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

//    public int minMeetingRooms(Interval[] intervals) {
//        if (intervals == null || intervals.length == 0) {
//            return 0;
//        }
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
//
//        Queue<Interval> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
//
//        q.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            if (q.peek().end <= intervals[i].start) {
//                q.poll();
//            }
//            q.add(intervals[i]);
//        }
//        return q.size();
//    }
}
