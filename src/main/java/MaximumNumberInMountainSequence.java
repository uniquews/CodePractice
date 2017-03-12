/**
 * Created by shuaiwang on 3/12/17.
 */
public class MaximumNumberInMountainSequence {
    public int mountainSequence(int[] nums) {
        // Write your code here
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[start];
        }

        return nums[end];
    }
}
