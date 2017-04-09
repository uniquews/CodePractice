import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Implements LRU with {@link java.util.LinkedHashSet}.
 */
public class LRUCacheII {
    // Use a LinkedHashSet to keep keys in read order.
    private LinkedHashSet<Integer> keys;
    // Use a HashMap to store key value pair.
    private HashMap<Integer, Integer> values;
    private int capacity;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        this.keys = new LinkedHashSet<>(capacity);
        this.values = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            // throw new NullPointerException("Key not found!");
            return -1;
        }
        keys.remove(key);
        keys.add(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (values.size() < capacity || (values.size() == capacity && values.containsKey(key))) {
            values.put(key, value);
        } else {
            int oldestKey = keys.iterator().next();
            values.remove(oldestKey);
            keys.remove(oldestKey);
            values.put(key, value);
        }
        get(key);
    }
}
