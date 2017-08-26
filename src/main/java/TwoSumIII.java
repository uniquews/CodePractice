import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuaiwang on 8/26/17.
 */
public class TwoSumIII {
    Map<Integer, List<Long>> map;
    long index;
    public TwoSumIII() {
        map = new HashMap<>();
        index = 0;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        List<Long> indices = map.getOrDefault(number, new ArrayList<>());
        indices.add(index++);
        map.put(number, indices);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int n : map.keySet()) {
            if (map.containsKey(value - n)) {
                if (n == value - n) {
                    if (map.get(n).size() != 1)
                        return true;
                } else
                    return true;
            }
        }
        return false;
    }
}
