import com.sun.prism.impl.Disposer;
import utils.Record;

import java.util.*;

/**
 * Created by shuaiwang on 2/13/17.
 */
public class HighFive {
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < results.length; i++) {
            if (!map.containsKey(results[i].id)) {
                map.put(results[i].id, new PriorityQueue<>(Arrays.asList(results[i].score)));
            } else {
                PriorityQueue<Integer> scoreList = map.get(results[i].id);
                if (scoreList.size() == 5) {
                    if (scoreList.peek() < results[i].score) {
                        scoreList.poll();
                        scoreList.add(results[i].score);
                    }
                } else {
                    scoreList.add(results[i].score);
                }
            }
        }

        Map<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int total = 0;
            for (Integer score : entry.getValue()) {
                total += score;
            }
            result.put(entry.getKey(), 1.0 * (total / 5.0));
        }

        return result;
    }

//    public static void main()
}
