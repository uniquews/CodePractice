import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 1/18/17.
 */
public class FindAllDuplicatesinanArray {

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] < 0 ? -nums[i] - 1 : nums[i] - 1;
            if (nums[index] < 0) {
                result.add(nums[i] < 0 ? -nums[i] : nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesinanArray test = new FindAllDuplicatesinanArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        test.findDuplicates(nums);
    }
}
