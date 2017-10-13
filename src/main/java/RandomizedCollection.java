import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean result = false;
        if (!map.containsKey(val)) {
            result = true;
        }
        int size = list.size();
        Set<Integer> indices = map.getOrDefault(val, new HashSet<>());
        indices.add(size);
        map.put(val, indices);

        list.add(val);
        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index1 = map.get(val).iterator().next();
        int index2 = list.size() - 1;

        if (index1 == index2) {
            list.remove(index1);
            map.get(val).remove(index1);
            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            return true;
        }

        swap(index1, index2);
        list.remove(index2);

        map.get(val).remove(index1);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        map.get(list.get(index1)).remove(index2);
        map.get(list.get(index1)).add(index1);
        return true;
    }

    private void swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int pos = rand.nextInt(list.size());
        return list.get(pos);
    }
}
