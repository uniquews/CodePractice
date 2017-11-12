package fb;

import utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class DesireMeetingRange {
    public List<Interval> findMeetingTime(Interval desire, List<Interval> busy) {
        int lastEndTime = desire.start;
        busy.sort((a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();

        for (int i = 0; i < busy.size() && lastEndTime < desire.end; i++) {
            if (busy.get(i).start > lastEndTime) {
                int s = lastEndTime;
                int e = Math.min(busy.get(i).start, desire.end);
                result.add(new Interval(s, e));
            }

            lastEndTime = Math.max(busy.get(i).end, lastEndTime);
        }
        if (lastEndTime < desire.end) {
            result.add(new Interval(lastEndTime, desire.end));
        }
        return result;
    }
}
