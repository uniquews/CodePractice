/**
 * Created by shuaiwang on 10/4/16.
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            while (left <= right && nums[left] < k) { // for [6,7,8] 5
                left++;
            }

            while (left <= right && nums[right] >= k) { // for [6,7,8] 5
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++;
                right--;
            }
        }
        return left;
    }
}
