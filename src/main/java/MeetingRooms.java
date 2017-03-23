import utils.Interval;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shuaiwang on 3/22/17.
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start - intervals[i - 1].end < 0) {
                return false;
            }
        }
        return true;
    }
}
