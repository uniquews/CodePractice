import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuaiwang on 10/14/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            twoSum(nums, i + 1, 0 - n1, result);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int index, int target, List<List<Integer>> result) {
        int i = index, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> current = Arrays.asList(0 - target, nums[i], nums[j]);
                result.add(current);
                while (i + 1 < j && nums[i] == nums[i + 1]) {
                    i++;
                }

                while (j - 1 > i && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}
