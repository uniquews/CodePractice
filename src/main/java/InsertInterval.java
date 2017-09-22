import utils.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 7/29/17.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int index = 0;
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index));
            index++;
        }

        result.add(newInterval);
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            Interval last = result.get(result.size() - 1);
            last.start = Math.min(last.start, intervals.get(index).start);
            last.end = Math.max(last.end, intervals.get(index).end);
            index++;
        }

        for (; index < intervals.size(); index++) {
            result.add(intervals.get(index));
        }
        return result;
    }
}
