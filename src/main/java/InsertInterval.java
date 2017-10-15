import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/29/17.
 */
public class InsertInterval {
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result = new ArrayList<>();
//
//        int index = 0;
//        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
//            result.add(intervals.get(index));
//            index++;
//        }
//
//        result.add(newInterval);
//        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
//            Interval last = result.get(result.size() - 1);
//            last.start = Math.min(last.start, intervals.get(index).start);
//            last.end = Math.max(last.end, intervals.get(index).end);
//            index++;
//        }
//
//        for (; index < intervals.size(); index++) {
//            result.add(intervals.get(index));
//        }
//        return result;
//    }


    // follow up do it in place
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        int pos = binarySearch(intervals, newInterval);
//        intervals.add(pos, newInterval);
//        int index = pos + 1;
//        while (index < intervals.size() && intervals.get(index).start <= intervals.get(pos).end) {
//            if (index == pos + 1) {
//                intervals.get(pos).start = Math.min(intervals.get(pos).start, intervals.get(index).start);
//            }
//            intervals.get(pos).end = Math.max(intervals.get(pos).end, intervals.get(index).end);
//            intervals.remove(index);
//        }
//        return intervals;
//    }
//
//    private int binarySearch(List<Interval> list, Interval target) {
//        if (list == null || list.isEmpty()) {
//            return 0;
//        }
//
//        int start = 0;
//        int end = list.size() - 1;
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            Interval tmp = list.get(mid);
//            if (tmp.end == target.start) {
//                return mid;
//            } else if (tmp.end < target.start) {
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//
//        if (list.get(start).end >= target.start) {
//            return start;
//        } else if (list.get(end).end >= target.start) {
//            return end;
//        } else {
//            return end + 1;
//        }
//    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int pos = binarySearch(intervals, newInterval);
        int index = 0;
        int pivot = 0;
        if (pos > 0 && intervals.get(pos - 1).end >= newInterval.start) {
            intervals.get(pos - 1).end = Math.max(intervals.get(pos - 1).end, newInterval.end);
            pivot = pos - 1;
            index = pos;
        } else {
            intervals.add(pos, newInterval);
            pivot = pos;
            index = pos + 1;
        }

        while (index < intervals.size() && intervals.get(index).start <= intervals.get(pivot).end) {
            intervals.get(pivot).end = Math.max(intervals.get(pivot).end, intervals.get(index).end);
            intervals.remove(index);
        }
        return intervals;
    }

    private int binarySearch(List<Interval> list, Interval target) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            Interval tmp = list.get(mid);
            if (tmp.start == target.start) {
                return mid;
            } else if (tmp.start < target.start) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (list.get(start).start >= target.start) {
            return start;
        } else if (target.start > list.get(start).start && target.start <= list.get(end).start) {
            return end;
        } else  { // target.start >= list.get(end).start
            return end + 1;
        }
    }
}
