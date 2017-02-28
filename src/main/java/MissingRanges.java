import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/27/17.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null ) {
            result.add("0->99");
            return result;
        }

        if (nums.length == 0) {
            if (lower == upper) {
                result.add(new StringBuilder().append(lower).toString());
            } else {
                result.add(new StringBuilder().append(lower).append("->").append(upper).toString());
            }
            return result;
        }

        int left = lower, current = 0;
        for (int right = 0; right < nums.length; right++) {
            current = nums[right];
            if (left < current) {
                if (left == current - 1) {
                    result.add(Integer.toString(left));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(left).append("->").append(current - 1);
                    result.add(sb.toString());
                }
            }
            if (current == Integer.MAX_VALUE)
                return result;
            left = current + 1;
        }

        if (left < upper) {
            StringBuilder sb = new StringBuilder();
            sb.append(left).append("->").append(upper);
            result.add(sb.toString());
        } else if (left == upper) {
            StringBuilder sb = new StringBuilder();
            sb.append(left);
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] nums = {Integer.MAX_VALUE};
        int lower = 0;
        int upper = 99;
        System.out.print(test.findMissingRanges(nums, lower, upper));
    }
}
