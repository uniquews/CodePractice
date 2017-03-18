import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by shuaiwang on 3/17/17.
 */

// 容易错的地方是，remove function里，在list中swap 两个数的同时需要更新map里面对应的index
// remove必须要和数组末尾swap 否则删除就不是O(1)
// 不理解这种getRandom 如何保证Each element must have the same probability of being returned.

public class RandomizedSet {

    List<Integer> list;
    HashMap<Integer, Integer> map;
    int count;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

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

        int pos = map.get(val);
        int tmp = list.get(list.size() - 1);
        list.set(list.size() - 1, val);
        list.set(pos, tmp);
        map.put(tmp, pos);
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

