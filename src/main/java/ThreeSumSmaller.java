import java.util.Arrays;

/**
 * Created by shuaiwang on 3/5/17.
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return count;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int end = nums.length - 1, count = 0;

        while (start < end) {
            if (nums[start] + nums[end] >= target) {
                end--;
            } else {
                count += end - start;
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ThreeSumSmaller test = new ThreeSumSmaller();
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.print(test.threeSumSmaller(nums, target));
    }
}
