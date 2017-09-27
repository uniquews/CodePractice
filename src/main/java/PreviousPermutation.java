import java.util.ArrayList;
import java.util.Collections;

public class PreviousPermutation {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return nums;
        }

        int i = nums.size() - 2;
        while (i >= 0 && nums.get(i) <= nums.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            Collections.reverse(nums);
            return nums;
        }

        int j = nums.size() - 1;
        while (nums.get(j) >= nums.get(i)) {
            j--;
        }

        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);

        int left = i + 1;
        int right = nums.size() - 1;
        while (left < right) {
            tmp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, tmp);
            left++;
            right--;
        }
        return nums;
    }
}
