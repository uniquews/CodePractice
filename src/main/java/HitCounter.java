import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaiwang on 1/15/17.
 */
public class HitCounter {
    /** Initialize your data structure here. */
    private Queue<Integer> list;
    public HitCounter() {
        list = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        list.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!list.isEmpty() && timestamp - list.peek() >= 300) {
            list.poll();
        }
        return list.size();
    }
}
