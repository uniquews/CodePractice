/**
 * Created by shuaiwang on 7/8/17.
 */
public class NextPermutation {
//    public int[] nextPermutation(int[] nums) {
//        // write your code here
//        int start = nums.length - 2;
//        while (start >= 0 && nums[start] >= nums[start + 1]) {
//            start--;
//        }
//
//        if (start >= 0) {
//            int larger = nums.length - 1;
//            while (nums[larger] <= nums[start]) {
//                larger--;
//            }
//            swap(nums, larger, start);
//        }
//        reverse(nums, start + 1 , nums.length - 1);
//        return nums;
//    }
//
//    private void swap(int[] nums, int i, int j){
//        int tmp = nums[j];
//        nums[j] = nums[i];
//        nums[i] = tmp;
//    }
//
//    private void reverse(int[] nums, int left, int right){
//        while(left < right){
//            swap(nums, left, right);
//            left++;
//            right--;
//        }
//    }

    public void nextPermutation(int[] nums) {
        int firstSmall = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                firstSmall = i - 1;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }


        int i = nums.length - 1;
        while (i >= firstSmall && nums[i] <= nums[firstSmall]) {
            i--;
        }
        swap(nums, firstSmall, i);
        reverse(nums, firstSmall + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
