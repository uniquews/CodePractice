import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaiwang on 5/5/17.
 */
public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInArray test = new FindAllNumbersDisappearedInArray();
        int[] nums = {4,3,2,7,8,2,3,1};

        test.findDisappearedNumbers(nums);
    }
}
