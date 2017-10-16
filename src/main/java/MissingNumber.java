/**
 * Created by shuaiwang on 6/19/17.
 */
public class MissingNumber {
    // sum 有可能有overflow
    public int missingNumber(int[] nums) {
        int shouldBeSum = (0 + nums.length) * (nums.length + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return shouldBeSum - sum;
    }

//    public int missingNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != i && nums[i] < nums.length) {
//                swap(nums, i, nums[i]);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) {
//                return i;
//            }
//        }
//        return nums.length;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    // 最快！！！！
//    public int missingNumber(int[] nums) {
//
//        int xor = 0, i = 0;
//        for (i = 0; i < nums.length; i++) {
//            xor = xor ^ i ^ nums[i];
//        }
//
//        return xor ^ i;
//    }
}
