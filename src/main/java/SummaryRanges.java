import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/16/17.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            if (j == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                result.add(String.valueOf(nums[i]) + String.valueOf("->") + String.valueOf(nums[j]));
            }
            i = j;
        }
        return result;
    }
}
