import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/27/17.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int left = lower, current = 0;
        for (int right = 0; right < nums.length; right++) {
            current = nums[right];
            if (left < current) {
                result.add(buildStr(left, current - 1));
            }
            if (current == upper) // corner case: [Integer.MAX_INT]  lower = 0, upper = Integer.MAX_INT
                return result;
            left = current + 1;
        }

        result.add(buildStr(left, upper));
        return result;
    }

    private String buildStr(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        if (lower == upper) {
            sb.append(lower);
        } else {
            sb.append(lower).append("->").append(upper);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] nums = {Integer.MAX_VALUE};
        int lower = 0;
        int upper = 99;
        System.out.print(test.findMissingRanges(nums, lower, upper));
    }
}
