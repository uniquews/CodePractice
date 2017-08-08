import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 5/6/17.
 */
public class OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> level = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            level.add(String.valueOf(i));
        }

        while (level.size() != 1) {
            List<String> nextLevel = new ArrayList<>();
            int start = 0, end = level.size() - 1;
            while (start < end) {
                String tmp = "(" + level.get(start) + "," + level.get(end) + ")";
                nextLevel.add(tmp);
                start++;
                end--;
            }
            level.clear();
            level = nextLevel;
        }
        return level.get(0);
    }


}
