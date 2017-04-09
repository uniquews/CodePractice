import java.util.*;

/**
 * Created by shuaiwang on 4/9/17.
 */
public class LFUCache {
    public HashMap<Integer, Integer> values; // key -> value
    public HashMap<Integer, Integer> frequency; // key -> frequency
    public HashMap<Integer, LinkedHashSet<Integer>> sameFreqInLRU; // frequency -> <LRU order of keys>
    int size = 0;
    int min = 0;
    public LFUCache(int capacity) {
        values = new HashMap<>(capacity);
        frequency = new HashMap<>();
        sameFreqInLRU = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        if (!values.containsKey(key)) {
            return -1;
        }
        int currentFreq = frequency.get(key);
        frequency.put(key, currentFreq + 1);
        sameFreqInLRU.get(currentFreq).remove(key);
        if (min == currentFreq && sameFreqInLRU.get(currentFreq).size() == 0) {
            min++;
        }
        if (!sameFreqInLRU.containsKey(currentFreq + 1)) {
            sameFreqInLRU.put(currentFreq + 1, new LinkedHashSet<>(Arrays.asList(key)));
        } else {
            sameFreqInLRU.get(currentFreq + 1).add(key);
        }
        return values.get(key);
    }

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }

        if (values.size() == size) {
            int leastFreqUsedKey = sameFreqInLRU.get(min).iterator().next();
            sameFreqInLRU.get(min).remove(leastFreqUsedKey);
            frequency.remove(leastFreqUsedKey);
            values.remove(leastFreqUsedKey);
        }

        values.put(key, value);
        frequency.put(key, 1);
        if (sameFreqInLRU.containsKey(1)) {
            sameFreqInLRU.get(1).add(key);
        } else {
            sameFreqInLRU.put(1, new LinkedHashSet<>(Arrays.asList(key)));
        }
        min = 1;
    }
}
