/**
 * Created by shuaiwang on 7/8/17.
 */
public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int start = nums.length - 2;
        while (start >= 0 && nums[start] >= nums[start + 1]) {
            start--;
        }

        if (start >= 0) {
            int larger = nums.length - 1;
            while (nums[larger] <= nums[start]) {
                larger--;
            }
            swap(nums, larger, start);
        }
        reverse(nums, start + 1 , nums.length - 1);
        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
