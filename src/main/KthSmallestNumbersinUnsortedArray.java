package main;

/**
 * Created by shuaiwang on 11/25/16.
 */
public class KthSmallestNumbersinUnsortedArray {
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int start = l, end = r;
        int pivot = nums[end];

        int leftTail = start - 1;
        for (int rightHead = start; rightHead <= end - 1; rightHead++) {
            if (nums[rightHead] <= pivot) {
                leftTail++;
                swap(nums, leftTail, rightHead);
            }
        }
        swap(nums, leftTail + 1, end);

        return leftTail + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {9,3,2,4,8};
//        int[] input = {1,2,3,4,5,6,8,9,10,7};
        KthSmallestNumbersinUnsortedArray test = new KthSmallestNumbersinUnsortedArray();
        System.out.print(test.kthSmallest(3, input));
    }

}
