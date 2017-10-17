import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum4Print {
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> cache = new HashMap<>();
        return dfs(nums, target, cache);
    }

    private List<List<Integer>> dfs(int[] nums, int target, Map<Integer, List<List<Integer>>> cache) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        if (target < 0) {
            return null;
        }

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> next = dfs(nums, target - nums[i], cache);
            if (next == null) {
                continue;
            }
            for (List<Integer> l : next) {
                List<Integer> newNext = new ArrayList<>(l);
                newNext.add(0, nums[i]);
                result.add(newNext);
            }
        }

        cache.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum4Print test = new CombinationSum4Print();
        int[] nums = {1,2,3};
        int target = 4;
        List<List<Integer>> result = test.combinationSum4(nums, target);
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
