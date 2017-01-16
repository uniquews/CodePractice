/**
 * Created by shuaiwang on 1/15/17.
 */
public class MinimumMovestoEqualArrayElementsII {

    // Way 1 : partiton array by using median number. O(n)
    public int minMoves2(int[] nums) {
        int k = (nums.length + 1) / 2;
        findKthNumber(nums, 0, nums.length - 1, k);
        int start = 0, end = nums.length - 1, sum = 0;
        while (start < end) {
            sum += nums[end] - start;
            start++;
            end--;
        }
        return sum;
    }


    private int findKthNumber(int[] nums, int start, int end, int k) {
        int index = partition(nums, start, end);
        if (index + 1 == k) {
            return index;
        } else if (index < k) {
            return findKthNumber(nums, index + 1, end, k);
        } else {
            return findKthNumber(nums, start, index - 1, k);
        }
    }


    private int partition(int[] nums, int start, int end) {
        int leftTail = start;
        int pivot = nums[end];

        for (int i = start; i <= end - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, leftTail);
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

    //Way 2: sort array and use two pointer from left and right
}
