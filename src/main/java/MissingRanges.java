import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 2/27/17.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result =  new ArrayList<>();

        long current = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < current) // [1,1,1] 有重复
                continue;

            if (nums[i] == current) {
                current++;
                continue;
            } else {
                if (current == nums[i] - 1) {
                    String s = String.valueOf(current);
                    result.add(s);
                    current = (long)nums[i] + 1;
                } else {
                    String s = String.valueOf(current) + "->" + String.valueOf(nums[i] - 1);
                    result.add(s);
                    current = (long)nums[i] + 1;
                }
            }
        }
        String s;
        if (current <= upper) {
            if (current == upper)
                s = String.valueOf(current);
            else
                s = String.valueOf(current) + "->" + String.valueOf(upper);
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] nums = {0,Integer.MAX_VALUE};
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        System.out.print(test.findMissingRanges(nums, lower, upper));
    }
}
