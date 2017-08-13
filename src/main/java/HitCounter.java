import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaiwang on 1/15/17.
 */
public class HitCounter {
    /** Initialize your data structure here. */
    Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while (!q.isEmpty() && q.peek() < timestamp - 300) {
            q.poll();
        }
        q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peek() <= timestamp - 300) {
            q.poll();
        }
        return q.size();
    }
}
