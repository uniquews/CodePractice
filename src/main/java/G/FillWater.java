package G;

import java.util.*;

public class FillWater {
    public boolean fillWater(int[] target, List<int[]> nums) {
        Map<List<Integer>, Boolean> cache = new HashMap<>();
        return helper(target, nums, cache);
    }

    private boolean helper(int[] target, List<int[]> nums, Map<List<Integer>, Boolean> cache) {
        if (target[0] <= 0 && target[1] >= 0) {
            return true;
        }

        if (target[1] < 0) {
            return false;
        }

        List<Integer> key = new ArrayList(Arrays.asList(target));
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        for (int i = 0; i < nums.size(); i++) {
            int[] cur = nums.get(i);
            int[] next = {target[0] - cur[1], target[1] - cur[0]};
            if (helper(next, nums, cache)) {
                cache.put(key, true);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] target = {1000, 1050};
        int[] a = {170, 180};
        int[] b = {270, 280};
        int[] c = {500, 515};
        List<int[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        FillWater test = new FillWater();
        System.out.print(test.fillWater(target, list));
    }
}
