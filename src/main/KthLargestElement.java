package main;

/**
 * Created by shuaiwang on 11/27/16.
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int start, int end, int k) {
        int position = partitionn(nums, start, end);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, end, k);
        } else {
            return helper(nums, start, position - 1, k);
        }
    }

    private int partitionn(int[] nums, int start, int end) {
        int leftTail = start - 1;
        int pivot = nums[end];
        for (int rightHead = start; rightHead <= end - 1; rightHead++) {
            if (nums[rightHead] >= pivot) {
                swap(nums, leftTail + 1, rightHead);
                leftTail++;
            }
        }
        swap(nums, leftTail + 1, end);
        return leftTail + 1;
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
