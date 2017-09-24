import java.util.*;

/**
 * Created by shuaiwang on 3/17/17.
 */

// 容易错的地方是，remove function里，在list中swap 两个数的同时需要更新map里面对应的index
// remove必须要和数组末尾swap 否则删除就不是O(1)
// 不理解这种getRandom 如何保证Each element must have the same probability of being returned.

class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);

        int tmp = list.get(index);
        list.set(index, list.get(list.size() - 1));
        list.set(list.size() - 1, tmp);

        map.put(list.get(index), index); // swap之后要记得update 被换过来的value的 index  而且要在remove之前，如果在remove之后，list 为空就越界了
        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

