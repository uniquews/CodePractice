import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 5/6/17.
 */
public class OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(String.valueOf(i));
        }

        while (n != 1) {
            List<String> nextQueue = new ArrayList<>();
            int start = 0, end = queue.size() - 1;
            while (start <= end) {
                String tmp = "(" + queue.get(start) + "," + queue.get(end) + ")";
                nextQueue.add(tmp);
                start++;
                end--;
            }
            queue.clear();
            queue = nextQueue;
            n /= 2;
        }
        return queue.get(0);
    }


}
