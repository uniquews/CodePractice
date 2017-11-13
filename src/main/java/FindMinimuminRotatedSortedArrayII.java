/**
 * Created by shuaiwang on 5/24/17.
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                start++;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
