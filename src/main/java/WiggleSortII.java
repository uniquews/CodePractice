/**
 * Created by shuaiwang on 1/14/17.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int k = (nums.length + 1) / 2;
        int median = nums[findKthNumber(nums, 0, nums.length - 1, k)];
        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        threeWayPartition(tmp, median);
        fillOutDate(nums, tmp);
    }

    // 思路：前半段的大数和后半段的大叔 放到一起，这样前半段的后半的部分（中位数）被放到了最后，
    // 后半段的前半部分（中位数）放到了最开始；
    // 如果我们把小的和小的放到一起，即前半段的前半部分和后半段的前半部分，这样中位数部分都会挤在最后，比如{4,5,5,6}
    private void fillOutDate(int[] nums, int[] tmp) {
        int first = (tmp.length - 1) / 2;
        int second = tmp.length - 1;

        int i = 0, j = 1;
        while (i < nums.length) {
            if (j == nums.length) {
                nums[i] = tmp[first];
                i++;
            } else {
                nums[i] = tmp[first];
                nums[j] = tmp[second];
                first--;
                second--;
                i += 2;
                j += 2;
            }
        }
    }

    private void threeWayPartition(int[] nums, int median) { // sort color
        int left = 0;
        int cur = 0;
        int right = nums.length - 1;

        while (cur <= right) {
            if (nums[cur] < median) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == median) {
                cur++;
            } else {
                swap(nums, cur, right);
                right--;
            }
        }
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
            if (nums[i] < pivot) {
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

    public static void main(String[] args) {
//        int[] a = {4,5,5,6};
//        int[] a = {1,2,1,2,1,2,1};
        int[] a = {5,3,1,2,6,7,8,5,5};
        WiggleSortII test = new WiggleSortII();
        test.wiggleSort(a);
        System.out.print(a);
    }
}
