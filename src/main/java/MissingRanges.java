import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/27/17.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        long current = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < current) { // 有重读[1,1,1]
                continue;
            }

            if (nums[i] == current) {
                current++;
                continue;
            }

            String s = convertToString(current, nums[i] - 1);
            result.add(s);
            current = (long)nums[i] + 1;
        }

        if (current > upper) {
            return result;
        }

        String last = convertToString(current, upper);
        result.add(last);
        return result;
    }

    private String convertToString(long start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }

        return String.valueOf(start) + "->" + String.valueOf(end);
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] nums = {0,Integer.MAX_VALUE};
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        System.out.print(test.findMissingRanges(nums, lower, upper));
    }
}
