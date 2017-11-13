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

        int num1 = val;
        int num2 = list.get(list.size() - 1);

        swap(index1, index2);

        map.get(num1).remove(index1);
        map.get(num2).remove(index2);

        map.get(num1).add(index2);
        map.get(num2).add(index1);

        map.get(num1).remove(index2);

        if (map.get(num1).size() == 0) {
            map.remove(num1);
        }
        list.remove(list.size() - 1);
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
