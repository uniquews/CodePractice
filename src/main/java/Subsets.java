import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachResult = new ArrayList<>();
        helper(result, eachResult, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> eachResult, int[] nums, int index) {
        result.add(new ArrayList<>(eachResult));

        for (int i = index; i < nums.length; i++) {
            eachResult.add(nums[i]);
            helper(result, eachResult, nums, i + 1);
            eachResult.remove(eachResult.size() - 1);
        }
    }
}
