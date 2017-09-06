/**
 * Created by shuaiwang on 11/27/16.
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int start, int end, int k) {
        int pos = partition(nums, start, end);
        if (pos + 1 == k) {
            return nums[pos];
        } else if (pos + 1 < k) {
            return helper(nums, pos + 1, end, k);
        } else {
            return helper(nums, start, pos - 1, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int leftTail = 0;
        for (int i = 0; i < end; i++) {
            if (nums[i] >= pivot) {
                swap(nums, leftTail, i);
                leftTail++;
            }
        }
        swap(nums, leftTail, end);
        return leftTail;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
