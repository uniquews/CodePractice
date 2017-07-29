import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/29/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }

        result.add(newInterval);
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval in = result.get(result.size() - 1);
            in.start = Math.min(in.start, intervals.get(i).start);
            in.end = Math.max(in.end, intervals.get(i).end);
            i++;
        }

        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}
