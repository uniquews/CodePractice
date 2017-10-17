import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// If we want to insert an element which is a dup, we can only insert it after the newly inserted elements from last step.

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> eachResult = new ArrayList<>();
        result.add(eachResult);
        int size = 0;
        for (int i = 0; i < nums.length; i++) {

            int startIndex = i > 0 && nums[i] == nums[i - 1] ? size : 0; // 上一轮的size
            size = result.size();
            for (int j = startIndex; j < size; j++) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
