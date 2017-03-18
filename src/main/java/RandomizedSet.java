import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by shuaiwang on 3/17/17.
 */
public class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    int count;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        count = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        count = 0;
        int pos = list.size();
        list.add(val);
        map.put(val, pos);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        count = 0;
        int pos = map.get(val);
        map.remove(val);
        list.remove(pos);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        if (count == size) {
            count = 0;
        }
        int endPosition = size - count - 1;
        Random random = new Random();
        int peekPosition = random.nextInt(size);
        int result = list.get(peekPosition);
        list.set(endPosition, list.get(peekPosition));
        count++;
        return result;
    }
}
