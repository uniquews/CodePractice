import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by shuaiwang on 2/27/17.
 */
public class MovingAverageFromDataStream {

    private Queue<Integer> list;
    private int sum;
    private int len;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        list = new LinkedList();
        sum = 0;
        len = size;
    }

    public double next(int val) {
        if (list.size() < len) {
            list.add(val);
            sum += val;
            return sum * 1.0 / list.size() * 1.0;
        } else {
            int out = list.poll();
            sum -= out;
            list.add(val);
            sum += val;
            return sum * 1.0 / len * 1.0;
        }
    }
}
