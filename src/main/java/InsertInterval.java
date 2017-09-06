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
            result.add(intervals.get(i++));
        }

        result.add(newInterval);
        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            Interval last = result.get(result.size() - 1);
            last.start = Math.min(last.start, intervals.get(i).start);
            last.end = Math.max(last.end, intervals.get(i).end);
            i++;
        }

        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}
