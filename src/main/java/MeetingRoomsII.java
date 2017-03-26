import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shuaiwang on 3/23/17.
 */
public class MeetingRoomsII {
    class Time {
        public int t;
        public boolean isStart;
        public Time(int tt, boolean start) {
            t = tt;
            isStart = start;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Time startTime = new Time(intervals[i].start, true);
            Time endTime = new Time(intervals[i].end, false);
            list.add(startTime);
            list.add(endTime);
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.t < o2.t) {
                return -1;
            } else if (o1.t > o2.t) {
                return 1;
            } else {
                if (o1.isStart && !o2.isStart) { //把end time 排在前面
                    return 1;
                }
                return -1; // 剩下的所有情况都可以排成 o1, o2
            }
        });

        int result = 0;
        int currentRoomNumber = 0;
        for (Time time : list) {
            if (time.isStart) {
                currentRoomNumber++;
            }
            if (!time.isStart) {
                currentRoomNumber--;
            }
            result = Math.max(result ,currentRoomNumber);
        }
        return result;
    }
}
