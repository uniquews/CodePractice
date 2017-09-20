import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }

        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });

        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > result.get(result.size() - 1).end) {
                result.add(cur);
            } else {
                result.get(result.size() - 1).end = Math.max(cur.end, result.get(result.size() - 1).end);
            }
        }
        return result;
    }
}
