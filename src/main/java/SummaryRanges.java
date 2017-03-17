import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 3/16/17.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }

            if (j - 1 == i) {
                result.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]).append("->").append(nums[j - 1]);
                result.add(sb.toString());
                i = j - 1;
            }
        }
        return result;
    }
}
