import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 5/7/17.
 */
public class MaximumVacationDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        HashMap<Integer, HashMap<Integer, Integer>> mem = new HashMap<>();
        return dfs(flights, days, 0, 0, mem);
    }

    private int dfs(int[][] flights, int[][] days, int city, int week, HashMap<Integer, HashMap<Integer, Integer>> mem) {
        if (week == days[0].length) {
            return 0;
        }

        if (mem.containsKey(city) && mem.get(city).containsKey(week)) {
            return mem.get(city).get(week);
        }
        int[] starts = flights[city];
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < starts.length; i++) {
            if (i == city || starts[i] == 1) {
                int currentWeekVacationDay = days[i][week];
                int future = dfs(flights, days, i,week + 1,  mem);
                currentMax = Math.max(currentMax, currentWeekVacationDay + future);
            }
        }

        if (!mem.containsKey(city)) {
            HashMap<Integer, Integer> weekToVacation = new HashMap<>();
            weekToVacation.put(week, currentMax);
            mem.put(city, weekToVacation);
        } else if (!mem.get(city).containsKey(week)) {
            HashMap<Integer, Integer> weekToVacation = mem.get(city);
            weekToVacation.put(week, currentMax);
        }
        return currentMax;

    }
}
